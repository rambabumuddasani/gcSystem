package com.rainier.gc.system.gc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.repositories.DustBinRepository;
import com.rainier.gc.system.gc.services.generic.GenericrEntityServiceImpl;

@Service
@Transactional
public class DutBinServiceImpl extends GenericrEntityServiceImpl<Long, DustBin> implements DustBinService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DutBinServiceImpl.class);

	private DustBinRepository binRepository;

	@Autowired
	public DutBinServiceImpl(DustBinRepository repository) {
		super(repository);
		binRepository = repository;
	}

	@Override
	public DustBin findBinByBarCode(String barCode) {
		return binRepository.findByBarCode(barCode);
	}

	@Override
	public List<DustBin> findAllDustBin() {
		return this.list();
	}
}
