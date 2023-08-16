package ru.saydum.app.controller.web;

import org.springframework.web.bind.annotation.*;
import ru.saydum.app.entity.Post;
import ru.saydum.app.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:80")
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("")
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        try {
            postRepository.findAll().forEach(posts::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") Integer id) {
        Post post = new Post();
        try {
            post = postRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }
}
