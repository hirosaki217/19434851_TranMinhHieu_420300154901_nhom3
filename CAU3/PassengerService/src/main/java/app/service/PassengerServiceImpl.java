package app.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import app.entity.Passenger;
import app.repository.PassengerRepository;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	private static final String REDIS_CACHE_VALUE = "passenger";
	@Autowired
	private PassengerRepository repo;
	 @Autowired
	    private RedisTemplate template;
	@Override
	public Passenger findById(String id) {
		Passenger passenger =  null;
		passenger = (Passenger) template.opsForHash().get(REDIS_CACHE_VALUE, id);
		if(passenger != null)
			return passenger;
		System.out.println("get from db");
		passenger = repo.findById(id).get();
		if(passenger.getId()!= null)
			template.opsForHash().put(REDIS_CACHE_VALUE, passenger.getId(), passenger);
		return passenger;
	}


	@Override
	public Passenger save(Passenger passenger) {
		template.opsForHash().put(REDIS_CACHE_VALUE, passenger.getId(), passenger);
		return repo.save(passenger);
	}
	

	
	
}
