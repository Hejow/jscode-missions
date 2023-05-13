package jscode.backend.module.post.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createAt;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @PrePersist
    public void createAt() {
        this.createAt = LocalDateTime.now();
    }

    public void update(PostData postData) {
        this.title = postData.getTitle();
        this.content = postData.getContent();
    }

    public static Post of(PostData postData) {
        return Post.builder()
                .title(postData.getTitle())
                .content(postData.getContent())
                .build();
    }
}
