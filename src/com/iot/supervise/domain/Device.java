package com.iot.supervise.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device_Device")//设备表
public class Device implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;//设备编号
	
	@Column(name = "DEVICE_NAME")
	private String devicename;//设备名称
	
	@Column(name = "DEVICE_IP")
	private String deviceip;//连接IP地址
	
	@Column(name = "DEVICE_PORT")
	private String deviceport;//监听端口号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getDeviceip() {
		return deviceip;
	}

	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	public String getDeviceport() {
		return deviceport;
	}

	public void setDeviceport(String deviceport) {
		this.deviceport = deviceport;
	}
	
	
}
