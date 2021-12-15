package com.nyadvlp.board.dto;

import com.nyadvlp.board.domain.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class FormDto {

    private String nickname;
    private int age;

}
