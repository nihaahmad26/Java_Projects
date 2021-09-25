package com.niha.language.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.language.models.Language;

@Repository
public interface LangRepository extends CrudRepository<Language, Long> {
	List<Language> findAll(); // SELECT * FROM languages.languages
}
