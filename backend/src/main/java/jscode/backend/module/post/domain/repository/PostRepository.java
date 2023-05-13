package jscode.backend.module.post.domain.repository;

import jscode.backend.module.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop100ByOrderByCreateAtDesc();
    List<Post> findTop100ByTitleContainingOrderByCreateAtDesc(String keyword);
}
