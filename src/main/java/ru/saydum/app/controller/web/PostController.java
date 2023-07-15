package ru.saydum.app.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.saydum.app.entity.Post;
import ru.saydum.app.repository.PostRepository;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        try {
            List<Post> posts = new ArrayList<>();
            postRepository.findAll().forEach(posts::add);
            model.addAttribute("posts", posts);
        } catch (Exception e) {
            model.addAttribute("error_message", e.getMessage());
        }
        return "web/blog/posts";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable("id") Integer id, Model model) {
        try {

            Post post = postRepository.findById(id).get();
            model.addAttribute("post", post);

        } catch (Exception e) {
            model.addAttribute("error_message", e.getMessage());
        }

        return "web/blog/show";
    }
}
