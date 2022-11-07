package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Passenger;

@Service
public interface PassengerService {
	Passenger findById(String id);
	Passenger save(Passenger passenger);

}
