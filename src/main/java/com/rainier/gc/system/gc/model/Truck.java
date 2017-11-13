package com.rainier.gc.system.gc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.rainier.gc.system.gc.model.generic.GenericEntity;


/**
 * The persistent class for the TRUCK database table.
 * 
 */

@Entity
@Table(name = "TRUCK", schema=SchemaConstant.GC_APP_SCHEMA)
public class Truck  extends GenericEntity<Long, Truck>{

	private static final long serialVersionUID = 8755799199503489635L;

	@Id
	@Column(name = "TRUCK_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "GC_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
		pkColumnValue = "TRUCK_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@Column(name = "UNIQE_IDENTIFIER", nullable=false, unique=true, length=100)
	private String uniqueIdentifier;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CURRENT_DATE",nullable=false)
	private Date currentDate;

	@Column(name="LOCATION_CODE",nullable=false, length=100)
	private String locationCode;

	@Column(name="LATITUDE")
	private String latitude;

	@Column(name="LONGITUDE")
	private String longitude;

	@Column(name="STATUS",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private StatusEnum status;

	@Column(name="TRANSPORT_AGENT")
	private String transportAgent;

	@Column(name="VEHICLE_MANUFACTURER")
	private String vehicleManufacturer;

	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;

	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	@Column(name="VEHICLE_NUMBER")
	private String vehicleNo;


	@Column(name="VEHICLE_TYPE",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private VehicleTypeEnum vehicleType;

	public Truck() {
	}

	public Date getCurrentDate() {
		return this.currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getTransportAgent() {
		return this.transportAgent;
	}

	public void setTransportAgent(String transportAgent) {
		this.transportAgent = transportAgent;
	}

	public String getUniqueIdentifier() {
		return this.uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}

	public String getVehicleManufacturer() {
		return this.vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleName() {
		return this.vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}

}