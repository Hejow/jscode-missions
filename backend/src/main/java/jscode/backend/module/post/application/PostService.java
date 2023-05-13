package jscode.backend.module.post.application;

import jscode.backend.global.exception.ErrorInformation;
import jscode.backend.global.exception.domain.PostException;
import jscode.backend.module.post.domain.Post;
import jscode.backend.module.post.domain.PostData;
import jscode.backend.module.post.domain.repository.PostRepository;
import jscode.backend.module.post.presentation.dtos.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponse> getAll() {
        List<Post> posts = postRepository.findTop100ByOrderByCreateAtDesc();
        return toResponses(posts);
    }

    public PostResponse get(Long id) {
        Post post = findById(id);
        return PostResponse.of(post);
    }

    public List<PostResponse> searchWithKeyword(String keyword) {
        List<Post> posts = postRepository.findTop100ByTitleContainingOrderByCreateAtDesc(keyword);
        return toResponses(posts);
    }

    @Transactional
    public PostResponse create(PostData postData) {
        Post post = postRepository.save(Post.of(postData));
        return PostResponse.of(post);
    }

    @Transactional
    public PostResponse update(Long id, PostData postData) {
        Post post = findById(id);
        post.update(postData);
        return PostResponse.of(post);
    }

    @Transactional
    public void delete(Long id) {
        Post post = findById(id);
        postRepository.delete(post);
    }

    private Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorInformation.POST_NOT_FOUND));
    }

    private List<PostResponse> toResponses(List<Post> posts) {
        return posts.stream()
                .map(PostResponse::of)
                .collect(Collectors.toList());
    }
}
