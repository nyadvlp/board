package com.nyadvlp.board.domain.repository;

import com.nyadvlp.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository 굳이 안 달아도 됨. 달아도 에러는 안 남
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // JpaRepository 인터페이스를 상속함
    // 제네릭 타입은 <Entity클래스, PK타입> 을 명시하면 됨
}
