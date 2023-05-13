package jscode.backend.module.post.presentation.mapper;

import jscode.backend.module.post.domain.PostData;
import jscode.backend.module.post.presentation.dtos.request.PostRequest;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostData mapFrom(PostRequest request) {
        return PostData.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }
}
