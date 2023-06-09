package com.atteam.atshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Roleid")
	private String roleId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
	
	@Column(name = "Rolename")
	private String roleName;
}
