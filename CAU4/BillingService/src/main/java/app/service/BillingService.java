package app.service;


import app.dto.BillingDto;
import app.entity.Billing;

public interface BillingService {
		Billing save(Billing bill);
		BillingDto findById(String id);
}
