package com.rainier.gc.system.gc.utils;

import java.util.Date;

import com.rainier.gc.system.gc.dto.TruckDTO;
import com.rainier.gc.system.gc.model.BarCode;
import com.rainier.gc.system.gc.model.Truck;

public class CreateTruckDataPopulator extends AbstractDataPopulator<TruckDTO, Truck> {

	@Override
	public Truck populate(TruckDTO source, Truck target)  {
		BarCode bC = new BarCode(source.getBarCode(), source.getBarCodeUrl(), source.getBarCodeText());
		target.setBarCode(bC); // set BarCode properties once generated.
		target.setLocationCode(source.getLocationCode());
		target.setStatus(source.getStatus());
		target.setTransportAgent(source.getTransportAgent());
		target.setUpdatedDate(new Date());
		target.setVehicleManufacturer(source.getVehicleManufacturer());
		target.setVehicleModel(source.getVehicleModel());
		target.setVehicleName(source.getVehicleName());
		target.setVehicleNo(source.getVehicleNo());
		target.setVehicleType(source.getVehicleType());
		return target;
	}

	@Override
	protected Truck createTarget() {
		return new Truck();
	}

}
