package ru.saydum.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saydum.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
