package me.whiteship.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository 인터페이스를 통해 DB Layer 접근자를 수행
// @Repository를 추가할 필요가 없습니다.
// CRUD(create, read, update, delete) 메소드 자동 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // SpingDataJpa에서 제공하지 않는 메소드는 쿼리로 직접 작성.
    List<Posts> findAllDesc();

}
