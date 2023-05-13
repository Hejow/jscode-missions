package jscode.backend.module.post.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostData {
    private String title;
    private String content;
}
