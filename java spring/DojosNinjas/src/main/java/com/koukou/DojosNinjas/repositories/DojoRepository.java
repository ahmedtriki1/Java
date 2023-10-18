package com.koukou.DojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.koukou.DojosNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List <Dojo> findAll();
}
