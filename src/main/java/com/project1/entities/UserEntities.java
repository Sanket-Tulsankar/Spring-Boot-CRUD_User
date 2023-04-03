package com.project1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="User")
public class UserEntities extends UserBaseEntity {

	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String email;
	@OneToOne
	private AuthenticationInfo authInfo;
}
