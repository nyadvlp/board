package com.nyadvlp.board.controller;

import com.nyadvlp.board.dto.BoardDto;
import com.nyadvlp.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    @GetMapping("/")
    public String list() {
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @GetMapping("/test")
    public String test(Model model, String name) {
        System.out.println("test name : " + name);
        model.addAttribute("yourname", name);
        return "board/test.html";
    }

    @PostMapping ("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}