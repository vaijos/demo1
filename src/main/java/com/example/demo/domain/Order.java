package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order implements Serializable {

	@Id
	String orderID;
	String clientName;
	
	@OneToMany(mappedBy="order" , fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	//@OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	Set<Item> items;	
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	
}
