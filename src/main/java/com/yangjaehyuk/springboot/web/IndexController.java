package com.yangjaehyuk.springboot.web;

import com.yangjaehyuk.springboot.service.posts.PostsService;
import com.yangjaehyuk.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable String id, Model model) {

        Long ids;
        ids = Long.valueOf(id);

        PostsResponseDto dto = postsService.findById(ids);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
