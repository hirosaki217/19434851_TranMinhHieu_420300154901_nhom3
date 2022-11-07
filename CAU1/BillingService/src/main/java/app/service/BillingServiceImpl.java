package app.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Billing;
import app.repository.BillingRepository;

@Service
@Transactional
public class BillingServiceImpl implements BillingService{
	@Autowired
	private BillingRepository repo;
	

	
	public Billing save(Billing bill) {
		return repo.save(bill);
	}

	public Billing findById(String id) {
		
		Billing bill = repo.findById(id).get();

		return bill;
	}



}
