package me.whiteship.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트의 자동 설정, Bean 읽기와 생성을 모두 자동으로 설정, 프로젝트 최상단에 위치해야한다
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // SpringApplication.run() : 내장 WAS 실행
    }
}
