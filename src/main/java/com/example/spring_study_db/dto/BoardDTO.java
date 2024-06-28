package com.example.spring_study_db.dto;

import com.example.spring_study_db.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String Title;
    private String Content;
    private Long view;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setTitle(boardEntity.getTitle());
        boardDTO.setContent(boardEntity.getContent());
        boardDTO.setView(boardEntity.getView());

        return boardDTO;
    }
}
