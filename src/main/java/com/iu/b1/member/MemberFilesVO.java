package com.iu.b1.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "memberFiles")
public class MemberFilesVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum; 
	private String id; 
	private String fname; 
	private String oname; 
	
	
	
	
	
}
