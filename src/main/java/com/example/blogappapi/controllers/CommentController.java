package com.example.blogappapi.controllers;

import com.example.blogappapi.entities.Comment;
import com.example.blogappapi.payloads.ApiResponse;
import com.example.blogappapi.payloads.CommentDto;
import com.example.blogappapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment) {
        CommentDto createComment = this.commentService.createComment(comment);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);
        return ResponseEntity.ok(new ApiResponse("Comment deleted successfully!!", true));
    }
}
