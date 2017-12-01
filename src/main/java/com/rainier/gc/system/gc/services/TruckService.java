package com.rainier.gc.system.gc.services;

import java.util.List;

import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.services.generic.GenericEntityService;

public interface TruckService  extends GenericEntityService<Long, Truck>{

	Truck findTruckByBarCode(String barCode);
	
	List<Truck> findAllTruck();
}
