package br.edu.ifpb.es.daw.entities.unidirecional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity(name = "OrderLine_UNI")
@Table(name = "ORDERS_LINE")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String item;

	private Double unitPrice;

	private Integer quantity;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderLine)) return false;
		OrderLine orderLine = (OrderLine) o;
		return Objects.equals(item, orderLine.item);
	}

	@Override
	public int hashCode() {
		return Objects.hash(item);
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
