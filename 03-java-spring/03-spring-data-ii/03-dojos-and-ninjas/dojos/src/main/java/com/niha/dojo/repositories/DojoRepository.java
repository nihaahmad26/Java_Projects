package com.niha.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.niha.dojo.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository <Dojo, Long>{
	List<Dojo> findAll();
}
