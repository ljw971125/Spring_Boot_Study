package com.example.spring_study_db.service;

import com.example.spring_study_db.dto.BoardDTO;
import com.example.spring_study_db.entity.BoardEntity;
import com.example.spring_study_db.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BoardService {
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final BoardRepository boardRepository;

    public List<BoardDTO> findAll(){
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
    public BoardDTO findById(Long id){
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if(optionalBoardEntity.isPresent()){
            return BoardDTO.toBoardDTO(optionalBoardEntity.get());
        }else{
            return null;
        }
    }
    public void save(BoardDTO boardDTO){
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public void delete(Long id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public int updateView(Long id){
        return boardRepository.updateView(id);
    }

    public String savePost(BoardDTO boardDTO, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                Random r = new Random();
                int a = r.nextInt(10000);
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(uploadDir, a + "_" + fileName);
                Files.createDirectories(path.getParent());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                boardDTO.setImageUrl("/uploads/" + a + "_" +fileName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return "redirect:/board/";
    }
}