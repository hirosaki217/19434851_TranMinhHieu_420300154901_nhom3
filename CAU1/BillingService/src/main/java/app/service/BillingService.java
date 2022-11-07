package app.service;


import app.entity.Billing;

public interface BillingService {
		Billing save(Billing bill);
		Billing findById(String id);
}
