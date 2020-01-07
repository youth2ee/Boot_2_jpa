package com.iu.b1.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer>{

	/* MemberFilesVO findById(String id); */
	  
	  public List<MemberFilesVO> findById(String id)throws Exception;
	  public Boolean existsById(String id) throws Exception;

	

}
