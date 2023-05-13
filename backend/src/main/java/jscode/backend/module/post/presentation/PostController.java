package jscode.backend.module.post.presentation;

import jscode.backend.global.common.ApiResponse;
import jscode.backend.module.post.application.PostService;
import jscode.backend.module.post.presentation.dtos.request.PostRequest;
import jscode.backend.module.post.presentation.dtos.response.PostResponse;
import jscode.backend.module.post.presentation.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    @ResponseStatus(OK)
    @GetMapping
    public ApiResponse<List<PostResponse>> getAll() {
        List<PostResponse> responses = postService.getAll();
        return ApiResponse.success(responses);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public ApiResponse<PostResponse> get(@PathVariable Long id) {
        PostResponse response = postService.get(id);
        return ApiResponse.success(response);
    }

    @ResponseStatus(OK)
    @GetMapping("/search")
    public ApiResponse<List<PostResponse>> search(@RequestParam final String keyword) {
        List<PostResponse> responses = postService.searchWithKeyword(keyword);
        return ApiResponse.success(responses);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public ApiResponse<PostResponse> create(@RequestBody @Valid final PostRequest request) {
        PostResponse response = postService.create(postMapper.mapFrom(request));
        return ApiResponse.success(response);
    }

    @ResponseStatus(OK)
    @PutMapping("/{id}")
    public ApiResponse<PostResponse> update(@PathVariable Long id,
                                            @RequestBody @Valid final PostRequest request) {
        PostResponse response = postService.update(id, postMapper.mapFrom(request));
        return ApiResponse.success(response);
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        postService.delete(id);
        return ApiResponse.noContent();
    }
}
