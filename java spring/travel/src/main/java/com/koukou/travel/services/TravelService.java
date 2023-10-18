package com.koukou.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koukou.travel.models.Travel;
import com.koukou.travel.repositories.Travelrepo;


@Service
public class TravelService {
	@Autowired
	private Travelrepo travelrepo;
	
	// READ ALL
	public List<Travel> allTravels(){
		return travelrepo.findAll();
	}
	// CREATE
		public Travel createTravel(Travel t) {
			return travelrepo.save(t);
		}
		// READ ONE
		public Travel findTravel(Long id) {
			
			Optional<Travel> maybetravel = travelrepo.findById(id);
			if(maybetravel.isPresent()) {
				return maybetravel.get();
			}else {
				return null;
			}
		}
		
		// UPDATE 
		public Travel updateTravel(Travel t) {
			return travelrepo.save(t);
		}
		
		// DELETE
		public void deleteTravel(Long id) {
			travelrepo.deleteById(id);
		}
		
}
