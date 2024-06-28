package com.example.spring_study_db.repository;

import com.example.spring_study_db.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findById(Long id);

    @Modifying
    @Query("update BoardEntity p set p.view = p.view + 1 where p.id = :id")
    int updateView(Long id);
}