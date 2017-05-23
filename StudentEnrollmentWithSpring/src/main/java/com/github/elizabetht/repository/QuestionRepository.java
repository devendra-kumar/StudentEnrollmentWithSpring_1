package com.github.elizabetht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.elizabetht.model.FileModel;

@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<FileModel, Long> {

}
