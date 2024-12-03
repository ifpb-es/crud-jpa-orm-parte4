package br.edu.ifpb.es.daw.entities.bidirecional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.List;
import java.util.Objects;

@Entity(name = "Artist_BI")
@Table(name = "ARTISTS", uniqueConstraints = {
		@UniqueConstraint(name = "UC_ARTIST__SSN", columnNames = "SSN")
})
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long ssn;

	private String firstName;

	private String lastName;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ARTISTS_CDS",
			   joinColumns = @JoinColumn(name = "ARTIST_FK"), 
			   inverseJoinColumns = @JoinColumn(name = "CD_FK"))
	private List<CD> appearsOnCDs;

	public Artist() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<CD> getAppearsOnCDs() {
		return appearsOnCDs;
	}

	public void setAppearsOnCDs(List<CD> appearsOnCDs) {
		this.appearsOnCDs = appearsOnCDs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Artist)) return false;
		Artist artist = (Artist) o;
		return Objects.equals(ssn, artist.ssn);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(ssn);
	}

	@Override
	public String toString() {
		return "Artist{" +
				"id=" + id +
				", ssn=" + ssn +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", appearsOnCDs=" + appearsOnCDs +
				'}';
	}
}
