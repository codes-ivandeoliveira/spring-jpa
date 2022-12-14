package com.educandoweb.springjpa.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.springjpa.entities.pk.OrdemItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_ordemItem")
public class OrdemItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdemItemPk id = new OrdemItemPk();
	private Integer quantity;
	private Double price;

	public OrdemItem() {

	}

	public OrdemItem(Order order, Products product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {

		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Products getProducts() {

		return id.getProduct();
	}

	public void setProduct(Products product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubtotal() {

		return price * quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemItem other = (OrdemItem) obj;
		return Objects.equals(id, other.id);
	}

}
