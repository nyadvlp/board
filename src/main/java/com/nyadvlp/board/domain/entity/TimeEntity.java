package com.nyadvlp.board.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 테이블로 매핑하지 않고, 자식 클래스(엔티티)에게 매핑정보를 상속
@EntityListeners(AuditingEntityListener.class)
// 데이터 조작 시 자동으로 날짜를 수정해 주는 JPA의 Auditing 기능 사용
public abstract class TimeEntity {

    @CreatedDate // 이 속성이 없으면 null, 처음 저장될 때 생성일을 주입한다
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티가 수정될 때 수정일자를 주입
    private LocalDateTime modifiedDate;
}
