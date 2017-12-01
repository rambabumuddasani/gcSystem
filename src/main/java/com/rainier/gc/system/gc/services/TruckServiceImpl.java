package com.rainier.gc.system.gc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.repositories.TruckRepository;
import com.rainier.gc.system.gc.services.generic.GenericrEntityServiceImpl;

@Service
@Transactional
public class TruckServiceImpl extends GenericrEntityServiceImpl<Long, Truck> implements TruckService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private TruckRepository truckRepository;

	@Autowired
	public TruckServiceImpl(TruckRepository repository) {
		super(repository);
		truckRepository = repository;
	}

	@Override
	public Truck findTruckByBarCode(String barCode) {
		return truckRepository.findByBarCode(barCode);
	}
	
	@Override
	public List<Truck> findAllTruck() {
		return this.list();
	}
}
