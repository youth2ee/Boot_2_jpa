package com.iu.b1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="members")
public class MemberVO {

	@Id //primary key
	@NotEmpty
	private String id;
	//@Column(name="password")
	private String pw; 
	
	@Transient
	private String pw2; 
	
	private String name; 
	private String email;
}
