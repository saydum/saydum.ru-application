package ru.saydum.app.controller.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.saydum.app.entity.Post;
import ru.saydum.app.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        try {
            postRepository.findAll().forEach(posts::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @GetMapping("/posts/{id}")
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
