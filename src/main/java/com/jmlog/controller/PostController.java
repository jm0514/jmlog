package com.jmlog.controller;

import com.jmlog.domain.Post;
import com.jmlog.request.PostCreate;
import com.jmlog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        // 1.저장한 데이터 Entity - > response로 응답하기
        // 2.저장한 데이터의 primary_id -> response로 응답하기
        //          Client에서는 수신한 id를 post 조회 API를 통해서 데이터를 수신받음
        // 3.응답 필요 없음 -> Client에서 모든 POST(글) 데이터 context를 잘 관리함
        // Bad Case: 서버에서 반드시 이렇게 합니다! (fix)
        //          -> 서버에서 유연하게 대응하는 것이 좋다. -> 코드를 잘 짜야한다.
        //          -> 한 번에 일괄적으로 잘 처리되는 케이스가 없다.
        postService.write(request);
    }

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable(name = "postId") Long id){
        Post post = postService.get(id);
        return post;
    }

}
