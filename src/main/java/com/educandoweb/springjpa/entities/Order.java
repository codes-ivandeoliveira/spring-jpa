package com.educandoweb.springjpa.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.educandoweb.springjpa.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private Integer orderStatus;
	private Instant moment;

	@ManyToOne
	@JoinColumn(name = "client_id")

	private User client;
	@OneToMany(mappedBy = "id.order")
	private Set<OrdemItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)

	private Payment payment;

	public Order() {

	}

	public Order(Integer id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {

		if (orderStatus != null) {

			this.orderStatus = orderStatus.getCode();

		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrdemItem> getItens() {

		return items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Double getTotal() {

		Double sum = 0.0;
		for (OrdemItem x : items) {

			sum += x.getSubtotal();

		}
		
		return sum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
