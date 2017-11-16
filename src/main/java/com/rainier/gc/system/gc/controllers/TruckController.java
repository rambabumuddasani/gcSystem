package com.rainier.gc.system.gc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.json.ReadTruckResponse;
import com.rainier.gc.system.gc.services.TruckService;

@RestController
public class TruckController {

	@Autowired
	TruckService truckService;
	
	public ReadTruckResponse saveTruck(){
		return null;
	}

}