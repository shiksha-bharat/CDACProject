package com.app.dto;


import javax.validation.constraints.NotBlank;
import com.app.entities.Institutes;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


public class RegisterDeskDTO {
	@JsonProperty(access = Access.READ_ONLY)
	@NotBlank
	private Long id;
	@NotBlank
	private Long inst_id;
	
	@NotBlank
	private String autorityName;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String pos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInst_id() {
		return inst_id;
	}
	public void setInst_id(Long inst_id) {
		this.inst_id = inst_id;
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
		return "RegisterDeskDTO [id=" + id + ", inst_id=" + inst_id + ", autorityName=" + autorityName + ", username="
				+ username + ", password=" + password + ", pos=" + pos + "]";
	}	
}
