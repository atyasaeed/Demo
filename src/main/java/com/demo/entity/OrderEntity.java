package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderEntity {
	@Id
	private Integer orderId;
	private String orderName;
	private boolean eenabled;
	
	public boolean isEnabled() {
		return eenabled;
	}
	public void setEnabled(boolean enabled) {
		this.eenabled = enabled;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
