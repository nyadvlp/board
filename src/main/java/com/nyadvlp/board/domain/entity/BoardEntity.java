package com.nyadvlp.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 파라미터가 없는 기본 생성자를 추가하는 어노테이션 (JPA 사용을 위해서 필수적)
// access는 접근 권한을 설정하는 속성으로, protected BoardEntity 와 동일함
@Getter // @Setter를 선언하지 않은 이유 : 안정성을 위해 builder 패턴 사용
@Entity // JPA가 관리하는 클래스
@Table(name = "board") // name을 생략하면 테이블명으로 자동 매핑됨
public class BoardEntity extends TimeEntity {

    @Id // PK (식별자 필드)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 값 생성 전략
    private Long id;

    @Column(length = 10, nullable = false) // 엔티티의 필드를 테이블 칼럼에 매핑, length는 String만 가능능    private String writer;
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    // @Setter를 대체하여 안정성 있게 사용하며 빌더 패턴 클래스를 생성해 줌
    // Entity는 가장 코어한 비즈니스 로직, Request/Response는 DTO가 담당
    public BoardEntity(Long id, String title, String content, String writer) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

}
