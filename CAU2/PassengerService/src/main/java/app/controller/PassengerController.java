package app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Passenger;
import app.service.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;

	@GetMapping("/{id}")
	public Passenger getPassenger(@PathVariable String id) {
		return passengerService.findById(id);
	}

	@PostMapping()
	public Passenger save(@RequestBody Passenger passenger) {
		return passengerService.save(passenger);
	}


}
