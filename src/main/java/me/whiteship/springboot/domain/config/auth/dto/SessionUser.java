package me.whiteship.springboot.domain.config.auth.dto;

import lombok.Getter;
import me.whiteship.springboot.domain.user.User;

// 인증된 사용자 정보
@Getter
public class SessionUser {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
