package com.example.blogappapi.services.impl;

import com.example.blogappapi.entities.Comment;
import com.example.blogappapi.exceptions.ResourceNotFoundException;
import com.example.blogappapi.payloads.CommentDto;
import com.example.blogappapi.repositories.CommentRepo;
import com.example.blogappapi.repositories.PostRepo;
import com.example.blogappapi.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment ", "CommentId", commentId));
        this.commentRepo.delete(com);
    }
}
