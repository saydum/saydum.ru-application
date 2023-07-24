package ru.saydum.app.controller.admin;

import ru.saydum.app.entity.Post;
import ru.saydum.app.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/admin/posts")
public class CrudPostController {

    private final PostRepository postRepository;

    public CrudPostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Get all posts
    @GetMapping("")
    public List<Post> allPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);

        return posts;
    }

    // Get post by id
    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable("id") Integer id) {
        return postRepository.findById(id).get();
    }

    // Save new post
    @PostMapping("/save/")
    public Post saveNewPost(Post post) {
        return postRepository.save(post);
    }

    // Edit post by id
    @PutMapping("/update/{id}")
    public Post updatePostById(
            @PathVariable("id") Integer id,
            @RequestBody Post requestBodyPost
    ) {
        Post post = postRepository.findById(id).get();

        post.setTitle(requestBodyPost.getTitle());
        post.setText(requestBodyPost.getText());
        post.setPublished(requestBodyPost.getPublished());

        return post;
    }

    // Delete post by id
    @DeleteMapping("/delete/{id}")
    public String  deletePostById(@PathVariable("id") Integer id) {
        postRepository.deleteById(id);
        return "Delete OK";
    }
}