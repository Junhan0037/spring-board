package me.whiteship.springboot.domain.config.auth.dto;

import lombok.Getter;
import me.whiteship.springboot.domain.user.User;

import java.io.Serializable;

// 인증된 사용자 정보 dto
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
