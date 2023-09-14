package com.app.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class IdGenerator {
	@Id
	@Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		IdGenerator other = (IdGenerator) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
