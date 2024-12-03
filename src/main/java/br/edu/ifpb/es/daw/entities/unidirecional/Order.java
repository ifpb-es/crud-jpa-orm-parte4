package br.edu.ifpb.es.daw.entities.unidirecional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "Order_UNI")
@Table(name = "ORDERS", uniqueConstraints = {
		@UniqueConstraint(name = "UC_ORDER__NUMBER", columnNames = { "NUMBER" })
})
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private UUID number;

	@Column(nullable = false)
	private LocalDateTime creationDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORDER_FK")
	private List<OrderLine> orderLines;

	public Order() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getNumber() {
		return number;
	}

	public void setNumber(UUID number) {
		this.number = number;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return Objects.equals(number, order.number);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", number=" + number +
				", creationDate=" + creationDate +
				", orderLines=" + orderLines +
				'}';
	}
}
