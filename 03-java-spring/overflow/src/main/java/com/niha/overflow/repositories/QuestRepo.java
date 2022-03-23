package com.niha.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.overflow.models.Question;

@Repository
public interface QuestRepo extends CrudRepository <Question, Long>{
	List<Question> findAll();
}
