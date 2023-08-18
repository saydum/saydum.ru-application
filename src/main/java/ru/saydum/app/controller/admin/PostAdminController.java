package ru.saydum.app.controller.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.saydum.app.entity.Post;
import org.springframework.ui.Model;
import ru.saydum.app.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Controller
public class PostAdminController {

    private final PostRepository postRepository;

    public PostAdminController(PostRepository postRepository) { this.postRepository = postRepository; }

    @GetMapping("/admin/posts")
    public String getAllPosts(Model model) {

        try {
            List<Post> posts = new ArrayList<>();
            postRepository.findAll().forEach(posts::add);
            model.addAttribute("posts", posts);
        } catch (Exception e) {
            model.addAttribute("error_message", e.getMessage());
        }
        return "admin/post/all";
    }

    @GetMapping("/admin/posts/get/{id}")
    public String getPostById(
            @PathVariable("id") int id,
            Model model
    ) {
        try {
            Post post = new Post();
            post = postRepository.getById(id);
            model.addAttribute("post", post);
        } catch (Exception e) {
            model.addAttribute("error_message", e.getMessage());
        }

        return "admin/post/show";
    }

    @GetMapping("/admin/posts/add")
    public String addPostPage() {
        return "admin/post/add";
    }

    @PostMapping("/admin/posts/save")
    public RedirectView addedNewPost(Post post) {

        postRepository.save(post);
        return new RedirectView("/admin/posts");
    }

    @GetMapping("/admin/posts/delete/{id}")
    public RedirectView deletePostById(@PathVariable("id") int id) {
        postRepository.deleteById(id);
        return new RedirectView("/admin/posts");
    }

}
