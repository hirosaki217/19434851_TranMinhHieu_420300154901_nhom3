package app.service;


import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.dto.BillingDto;
import app.dto.PassengerDto;
import app.entity.Billing;
import app.repository.BillingRepository;

@Service
@Transactional
public class BillingServiceImpl implements BillingService{
	@Autowired
	private BillingRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public Billing save(Billing bill) {
		return repo.save(bill);
	}

	public BillingDto findById(String id) {
		
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		Billing bill = repo.findById(id).get();

		String passengerId = bill.getPassengerId();
		PassengerDto passengerDto = restTemplate.exchange("http://localhost:8082/passengers".concat("/").concat(passengerId), 
				 HttpMethod.GET, 
				 entity, 
				 PassengerDto.class
				).getBody();
		BillingDto billing = BillingDto.builder()
			.id(bill.getId())
			.name(bill.getName())
			.price(bill.getPrice())
			.passenger(passengerDto).build();
		return billing;
	}



}
