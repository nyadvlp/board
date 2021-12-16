package com.nyadvlp.board.controller;

import com.nyadvlp.board.dto.BoardDto;
import com.nyadvlp.board.dto.FormDto;
import com.nyadvlp.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    // 글목록
    @GetMapping("/")
    public String list(Model model) {
        System.out.println("list");

        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }

    // 글작성을 위한 뷰
    @GetMapping("/post")
    public String write() {
        System.out.println("GET - write");
        return "board/write.html";
    }

    // 글 작성하여 저장
    @PostMapping ("/post")
    public String write(BoardDto boardDto) {
        System.out.println("POST - write");
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    // 글 상세조회
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    // 글 삭제
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);
        return "redirect:/";
    }

    // 글 수정을 위한 뷰
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    // 글 수정하여 저장
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto, Model model) {
        boardService.savePost(boardDto);
        boardDto = boardService.getPost(boardDto.getId());
        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }


    // test

    @GetMapping("/testmain")
    public String testmain() {
        System.out.println("testmain");
        return "board/testmain.html";
    }

    @GetMapping("/paramtest")
    public String paramtest(Model model, String name) {
        System.out.println("paramtest");
        System.out.println("test name : " + name);
        model.addAttribute("yourname", name);
        return "board/paramtest.html";
    }

    @GetMapping("/formtest")
    public String showForm(Model model) {
        System.out.println("GET - showForm");
        model.addAttribute("testform", new FormDto());
        return "board/formtest.html";
    }

//    @PostMapping("/formtest")
//    public String showForm(@ModelAttribute("test2form") FormDto formDto) {
//        System.out.println("POST - showForm");
//        System.out.println("formDto : " + formDto.getNickname());
//        System.out.println("formDto : " + formDto.getAge());
//        return "board/formtestview.html";
//    }

    @PostMapping("/formtest")
    public String showForm(Model model, @RequestParam String nickname, @RequestParam int age) {
        System.out.println("POST - showForm");
        System.out.println("nickname : " + nickname);
        System.out.println("age : " + age);

        FormDto formDto = new FormDto();
        formDto.setNickname(nickname);
        formDto.setAge(age);
        model.addAttribute("test3form", formDto);
        return "board/formtestview.html";
    }
}