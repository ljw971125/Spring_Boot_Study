package com.example.spring_study_db.entity;

import com.example.spring_study_db.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "board")

public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Title;

    @Column
    private String Content;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private Long view;

    public static BoardEntity toBoardEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.id = boardDTO.getId();
        boardEntity.Title = boardDTO.getTitle();
        boardEntity.Content = boardDTO.getContent();
        boardEntity.view = boardDTO.getView();

        return boardEntity;
    }
}
