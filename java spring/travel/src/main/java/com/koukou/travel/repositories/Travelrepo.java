package com.koukou.travel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.koukou.travel.models.Travel;
@Repository
public interface Travelrepo extends CrudRepository<Travel, Long> {
	// Read All
		List<Travel> findAll();
}
