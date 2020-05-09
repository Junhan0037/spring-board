package me.whiteship.springboot.web;

import lombok.RequiredArgsConstructor;
import me.whiteship.springboot.service.PostsService;
import me.whiteship.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 페이지 관련 컨트롤러
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model. addAttribute("posts", postsService.findAllDesc()); // index.mustache에 posts로 전달
        return "index"; // index.mustache 호출
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; // posts-save.mustache 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update"; // posts-update.mustache 호출
    }

}
