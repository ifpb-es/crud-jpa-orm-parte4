package br.edu.ifpb.es.daw.entities.bidirecional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "CD_BI")
@Table(name = "CDS", uniqueConstraints = {
		@UniqueConstraint(name = "UC_CD__TITLE__DESCRIPTION", columnNames = {"TITLE", "DESCRIPTION"})
})
public class CD {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime creationDate;

	private String title;

	private Float price;

	private String description;

	@ManyToMany(mappedBy = "appearsOnCDs")
	private List<Artist> createdByArtists;

	public CD() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Artist> getCreatedByArtists() {
		return createdByArtists;
	}

	public void setCreatedByArtists(List<Artist> createdByArtists) {
		this.createdByArtists = createdByArtists;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CD)) return false;
		CD cd = (CD) o;
		return Objects.equals(title, cd.title) && Objects.equals(description, cd.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, description);
	}

	@Override
	public String toString() {
		return "CD{" +
				"id=" + id +
				", creationDate=" + creationDate +
				", title='" + title + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				'}';
	}
}
