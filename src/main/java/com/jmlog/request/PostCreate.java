package com.jmlog.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    @Builder //생성자에 빌더를 붙이는 것을 추천!
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //빌더의 장점
    // -가독성이 좋다.(값 생성에 대한 유연함)
    // -필요한 값만 받을 수 있다.
    // -객체의 불변성
}
