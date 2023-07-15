package ru.saydum.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saydum.app.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
