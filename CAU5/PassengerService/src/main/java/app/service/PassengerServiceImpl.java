package app.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Passenger;
import app.repository.PassengerRepository;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepository repo;
	
	@Override
	public Passenger findById(String id) {
		Passenger passenger = repo.findById(id).get();
		return passenger;
	}


	@Override
	public Passenger save(Passenger passenger) {
		return repo.save(passenger);
	}
	

	
	
}
