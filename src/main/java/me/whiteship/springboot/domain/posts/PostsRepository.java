package me.whiteship.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 인터페이스를 통해 DB Layer 접근자를 수행
// @Repository를 추가할 필요가 없습니다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
