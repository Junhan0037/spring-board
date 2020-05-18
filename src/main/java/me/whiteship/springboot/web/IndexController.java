package me.whiteship.springboot.web;

import lombok.RequiredArgsConstructor;
import me.whiteship.springboot.config.auth.LoginUser;
import me.whiteship.springboot.config.auth.dto.SessionUser;
import me.whiteship.springboot.service.PostsService;
import me.whiteship.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

// 페이지 관련 컨트롤러
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {  // 메소드 인자로 세션값을 바로 받을 수 있도록 한다.
        model.addAttribute("posts", postsService.findAllDesc()); // index.mustache에 posts로 전달
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); // CustomOAuth2UserService클래스에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구현함.
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index2"; // index2.mustache 호출
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
