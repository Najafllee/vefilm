package com.example.matrix151springboot.controller;
import com.example.matrix151springboot.model.CommentDto;
import com.example.matrix151springboot.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void addComment(@RequestBody CommentDto commentDto) {
        commentService.addComment(commentDto);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        commentService.updateComment(id, commentDto);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}

