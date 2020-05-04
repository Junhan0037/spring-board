package me.whiteship.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // Junit에 내장된 실행자 외에 다른 실행자를 실행 => 스프링 부트 테스트와 Junit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 테스트할 클래스
public class HelloControllerTest {
    
    @Autowired
    private MockMvc mvc; // 웹API 테스트, 스프링MVC 테스트의 시작점, HTTP GET, POST 등에 대한 테스트

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // HTTP header의 Status 검증 (200, 404, 500 등의 상태)
                .andExpect(content().string(hello)); // 응답 본문의 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount  = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) // 사용될 요청 파라미터를 설정
                        .param("amount", String.valueOf(amount))) // String만 허용
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // JSON 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
    
}
