package com.nyadvlp.board.service;

import com.nyadvlp.board.domain.entity.BoardEntity;
import com.nyadvlp.board.domain.repository.BoardRepository;
import com.nyadvlp.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
        // save는 JpaRepository에 정의된 메서드로, Insert와 Update를 담당하며 매개변수는 Entity임
    }

    @Transactional
    public List<BoardDto> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        // Entity로 받아온 것을 Dto에 담아주는 작업
        for (BoardEntity boardEntity : boardEntities) {
            BoardDto boardDto = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .modifiedDate(boardEntity.getModifiedDate())
                    .build();
            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }
}
