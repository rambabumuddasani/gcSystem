package com.rainier.gc.system.gc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.exception.BarCodeNoutFoundException;
import com.rainier.gc.system.gc.json.ReadBinResponse;
import com.rainier.gc.system.gc.json.ReadTruckResponse;
import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.services.DustBinService;
import com.rainier.gc.system.gc.services.TruckService;
import com.rainier.gc.system.gc.utils.DateUtil;

@RestController
public class BarCodeController {

	@Autowired
	TruckService truckService;

	@Autowired
	DustBinService dustBinService;
	
	
	
	
	/**
	 * TKXXX - TRUCK
	 * 
	 * BNXXXX - BIN
	 * @param barCode
	 * @return
	 * @throws BarCodeNoutFoundException 
	 */
	
	@GetMapping("/read-bar-code")
	public Map<String,Object> getObject(@PathParam("bcd") String barCode) throws BarCodeNoutFoundException{
		Map<String,Object> response = new HashMap<String,Object>();
		if(StringUtils.isEmpty(barCode) || barCode.length() < 2){
			throw new BarCodeNoutFoundException("Invalid bar code");
		}
		Object responseValue = null;
		String barCodeType = barCode.substring(0,2);
		if("TK".equals(barCodeType)){
			Truck truck = truckService.findTruckByBarCode(barCode);
			responseValue = populateTruckResponse(truck);
			response.put("truckDetails", responseValue);
		}else if("BN".equals(barCodeType)){
			DustBin bin = dustBinService.findBinByBarCode(barCode);
			responseValue = populateBinResponse(bin);
			response.put("binDetails", responseValue);
		}else {
			throw new BarCodeNoutFoundException("Invalid bar code type "+barCodeType);
		}
		response.put("", responseValue);
		return response;
	}
	
	private ReadTruckResponse populateTruckResponse(Truck truck){
		ReadTruckResponse response = new ReadTruckResponse();
		response.setId(truck.getId());
		response.setBarCode(truck.getBarCode().getBarCode());
		response.setBarCodeText(truck.getBarCode().getBarCodeText());
		response.setLocationCode(truck.getLocationCode());
		response.setStatus(truck.getStatus());
		response.setTransportAgent(truck.getTransportAgent());
		response.setUpdatedDate(DateUtil.formatDate(truck.getUpdatedDate()));
		response.setVehicleManufacturer(truck.getVehicleManufacturer());
		response.setVehicleModel(truck.getVehicleModel());
		response.setVehicleName(truck.getVehicleName());
		response.setVehicleNo(truck.getVehicleNo());
		response.setVehicleNo(truck.getVehicleNo());
		response.setVehicleType(truck.getVehicleType());
		return response;
	}
	
	private ReadBinResponse populateBinResponse(DustBin bin){
		ReadBinResponse response = new ReadBinResponse();
		response.setId(bin.getId());
		response.setBarCode(bin.getBarCode().getBarCode());
		response.setBarCodeText(bin.getBarCode().getBarCodeText());
		response.setBinCapacity(bin.getBinCapacity());
		response.setBinManufacturer(bin.getBinManufacturer());
		response.setBinModel(bin.getBinModel());
		response.setBinType(bin.getBinType());
		response.setDecommissionedDate(DateUtil.formatDate(bin.getDecommissionedDate()));
		response.setEmail(bin.getEmail());
		response.setInstalledDate(DateUtil.formatDate(bin.getInstalledDate()));
		response.setLastServiceDate(DateUtil.formatDate(bin.getLastServiceDate()));
		response.setLatitude(bin.getLatitude());
		response.setLongitude(bin.getLongitude());
		response.setLocationDescription(bin.getLocationDescription());
		response.setNextServiceDate(DateUtil.formatDate(bin.getNextServiceDate()));
		response.setNotes(bin.getNotes());
		response.setPhysicalAddress(bin.getPhysicalAddress());
		response.setServiceFrequency(bin.getServiceFrequency());
		response.setStatus(bin.getStatus());
		response.setTransporter(bin.getTransporter());
		response.setUniqueIdentifier(bin.getUniqueIdentifier());
		response.setWasteGenerator(bin.getWasteGenerator());
		response.setWasteOrigin(bin.getWasteOrigin());
		response.setWasteType(bin.getWasteType());
		return response;
	}
}
