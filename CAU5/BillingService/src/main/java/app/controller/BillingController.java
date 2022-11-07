package app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.dto.BillingDto;
import app.entity.Billing;
import app.service.BillingService;

@RestController
public class BillingController {
	@Autowired
	private BillingService service;
	
	
	
	@PostMapping("/billings")
	public Billing addBill(@RequestBody Billing bill) {
		return service.save(bill);
	}
	
	int count = 1;
	@GetMapping("billings/{id}")
	public BillingDto findById(@PathVariable String id) {

					
		return service.findById(id);
	}

}
