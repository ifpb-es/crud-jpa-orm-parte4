package br.edu.ifpb.es.daw.entities.bidirecional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity(name = "OrderLine_BI")
@Table(name = "ORDERS_LINE")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String item;

	private Double unitPrice;

	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORDER_FK")
	private Order order;

	public OrderLine() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public Order getOrder() {
		return order;
	}

	
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderLine)) return false;
		OrderLine orderLine = (OrderLine) o;
		return Objects.equals(item, orderLine.item) && Objects.equals(order, orderLine.order);
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, order);
	}

	@Override
	public String toString() {
		return "OrderLine{" +
				"quantity=" + quantity +
				", unitPrice=" + unitPrice +
				", item='" + item + '\'' +
				", id=" + id +
				'}';
	}
}
