package com.nyadvlp.board.dto;

import com.nyadvlp.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
// 파라미터가 없는 생성자를 생성함
// builder를 쓸 것이므로
public class BoardDto {
    // 자주 변경이 필요한 view를 위한 클래스는 DTO
    // Controller <-> Service <-> Repository 간 데이터 캡슐화한 객체

    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // DTO에서 필요한 부분을 빌더를 통해 엔티티로 만듦
    public BoardEntity toEntity () {
        BoardEntity boardEntity = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

}
