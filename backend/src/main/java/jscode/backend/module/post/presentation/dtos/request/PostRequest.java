package jscode.backend.module.post.presentation.dtos.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostRequest {
    @NotBlank
    @Size(min = 1, max = 15)
    private String title;

    @NotBlank
    @Size(min = 1, max = 1000)
    private String content;
}
