package com.jmlog.repository;

import com.jmlog.domain.Post;
import com.jmlog.request.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}
