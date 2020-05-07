package me.whiteship.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.whiteship.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성 (Lombok 어노테이션)
@NoArgsConstructor // 기본 생성자 자동 추가 (Lombok 어노테이션)
@Entity // 테이블과 링크될 클래스임을 의미 (JPA 어노테이션)
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK필드를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 설정, GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 된다
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 자동 설정
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함 (Lombok 어노테이션)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
