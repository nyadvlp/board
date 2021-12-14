package com.nyadvlp.board.service;

import com.nyadvlp.board.domain.repository.BoardRepository;
import com.nyadvlp.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    public long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
