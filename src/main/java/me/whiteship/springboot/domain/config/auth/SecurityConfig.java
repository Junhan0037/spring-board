package me.whiteship.springboot.domain.config.auth;

import lombok.RequiredArgsConstructor;
import me.whiteship.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 스프링 시큐리티 설정
@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정들을 활성화.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable한다.
                .and()
                    .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() // 전체 열람 권한.
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사람만 가능.
                    .anyRequest().authenticated() // anyRequest() : 설정한 값들 이외 나머지 URL. => 나머지 URL들은 모두 인증과정을 거친다.
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 "/" 주소로 이동.
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService); // userService() : 소셜 로그인 성공 시 후속조치를 진행할 구현체 등록.
    }

}
