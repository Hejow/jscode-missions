package jscode.backend.module.post.presentation.dtos.response;

import jscode.backend.module.post.domain.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createAt(post.getCreateAt())
                .build();
    }
}
