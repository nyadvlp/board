package com.nyadvlp.board.domain.repository;

import com.nyadvlp.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// @Repository 굳이 안 달아도 됨. 달아도 에러는 안 남
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // JpaRepository 인터페이스를 상속함
    // 제네릭 타입은 <Entity클래스, PK타입> 을 명시하면 됨


    // 검색
    List<BoardEntity> findByTitleContaining(String keyword);
    // By 이후는 where 절이라고 생각하면 되는데, Containing을 붙이면 Like 검색이 됨
    // 즉 %{keyword}% 이렇게 표현되는 것임
}
