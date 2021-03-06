package com.niha.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.overflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository <Answer, Long>{
	List<Answer> findAll();
}
