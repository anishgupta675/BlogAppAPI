package com.example.blogappapi.services;

import com.example.blogappapi.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto);
    void deleteComment(Integer commentId);
}
