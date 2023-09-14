package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "desk")
@NoArgsConstructor

public class Desks {
	@Autowired
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deskId;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Institutes inst;
	private String autorityName;
	private String username;
	private String password;
	@Column(length = 15)
	private String pos;
	public Long getDeskId() {
		return deskId;
	}
	public void setDeskId(Long id) {
		this.deskId = id;
	}
	public Institutes getInst() {
		return inst;
	}
	public void setInst(Institutes inst) {
		this.inst = inst;
	}
	public String getAutorityName() {
		return autorityName;
	}
	public void setAutorityName(String autorityName) {
		this.autorityName = autorityName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "Desks [id=" + deskId + ", inst=" + inst + ", autorityName=" + autorityName + ", username=" + username
				+ ", password=" + password + ", pos=" + pos + "]";
	}
	
	
	
	
	
	
	
}
