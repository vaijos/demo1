package com.example.demo.domain;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;  
@Entity  
//defining class name as Table name  
@Table  
public class Item implements Comparable<Item> , Serializable{
	@Id
	String itemID;
	String name;
	String description;
	double price;
	
	/////////////////////////////////
	//@ManyToOne(fetch = FetchType.LAZY, optional = false) ....optional = true(and nullable=true) ...will indicate that you don't have to set order
	  //for earch item. But that being false you would need to set order in each Item
    //@JoinColumn(name = "order_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore ....this avoids circular reference during json creation	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name="orderID", nullable=true)
    Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Transient
	private String clientName;
	
	
	public String getClientName() {
	 String tempstr = getOrder() != null ?  getOrder().getClientName() :  "" ;
	 return tempstr;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/////////////////////////////////
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		 return itemID  + ":"+ name + ":"+ description +":" + price; 

	}

	public int compareTo(Item pitem) {
		
		if (price > pitem.price) {
			return -1;
		}else if (pitem.price > price){
			return 1;
		}else {
			return 0;
		}
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(clientName, itemID, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(clientName, other.clientName) && Objects.equals(itemID, other.itemID)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	} 


}
