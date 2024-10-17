package com.example.spring_study_db.Controller;


import com.example.spring_study_db.dto.BoardDTO;
import com.example.spring_study_db.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/board/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardlist";
    }
    @GetMapping("/board/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        boardService.updateView(id);
        model.addAttribute("board", boardDTO);
        return "boarddetail";
    }

    @GetMapping("/board/save")
    public String saveForm(){
        return "boardwrite";
    }

//    @PostMapping("/board/save")
//    public String save(BoardDTO boardDTO) {
//        boardService.save(boardDTO);
//        return "redirect:/board/";
//    }
    @GetMapping("/board/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }

    @PostMapping("/board/save")
    public String savePost(BoardDTO boardDTO, @RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDir, fileName);
            boardDTO.setImageUrl("/uploads/"+fileName);
        }
        boardService.save(boardDTO);
        return "redirect:/board/";
    }
}
