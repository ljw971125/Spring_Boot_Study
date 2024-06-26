package com.example.spring_study_db.Controller;


import com.example.spring_study_db.dto.BoardDTO;
import com.example.spring_study_db.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardlist";
    }
    @GetMapping("/board/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boarddetail";
    }

    @GetMapping("/board/save")
    public String saveForm(){
        return "boardwrite";
    }

    @PostMapping("/board/save")
    public String save(BoardDTO boardDTO) {
        boardService.save(boardDTO);

        return "redirect:/board/";
    }
}
