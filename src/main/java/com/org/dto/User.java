package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	private int id;
	private String name;
	private int age;
	private long mobile;
	private String email;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Notes> notes;
	
}
