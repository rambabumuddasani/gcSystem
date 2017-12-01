package com.rainier.gc.system.gc.services;

import java.util.List;

import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.services.generic.GenericEntityService;

public interface DustBinService extends GenericEntityService<Long, DustBin>{

	DustBin findBinByBarCode(String barCode);
	
	List<DustBin> findAllDustBin();
}