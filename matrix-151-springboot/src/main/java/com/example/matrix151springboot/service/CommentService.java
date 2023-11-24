package com.example.matrix151springboot.service;


import com.example.matrix151springboot.mapper.CommentMapper;
import com.example.matrix151springboot.model.CommentDto;
import com.example.matrix151springboot.repositories.CommentRepository;
import com.example.matrix151springboot.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final FilmRepository filmRepository;
    private final CommentMapper commentMapper;

    public void addComment(CommentDto commentDto) {
        var filmEntity = filmRepository.findById(commentDto.getFilmId()).orElseThrow(
                () -> new RuntimeException("COMMENT_NOT_FOUND"));
        var commentEntity = commentMapper.dtoToEntity(commentDto);
        commentEntity.setFilmEntity(filmEntity);
        commentRepository.save(commentEntity);

    }

    public void updateComment(Long id, CommentDto commentDto) {
        var dto = commentMapper.dtoToEntity(commentDto);
        commentRepository.save(dto);
        dto.setId(id);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<CommentDto> getCommentList() {
        var commentEntityList = commentRepository.findAll();
        return commentEntityList.stream().map(commentMapper::entityToDto).collect(Collectors.toList());

    }
}
