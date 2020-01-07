package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberFilesRepositoryTest {

	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	
	@Test
	void test() throws Exception {
		//List<MemberFilesVO> ar = memberFilesRepository.findAll();
		//for(MemberFilesVO memberFilesVO:ar) {
		//	System.out.println(memberFilesVO.getOname());
		//}
		
		/*
		 * long count = memberFilesRepository.count(); System.out.println(count);
		 */
		/*
		 * Optional<MemberFilesVO> opt = memberFilesRepository.findById(1);
		 * Optional<MemberFilesVO> opt2 = memberFilesRepository.findById(1);
		 * MemberFilesVO memberFilesVO = opt.get(); MemberFilesVO memberFilesVO2 =
		 * opt2.get(); System.out.println(memberFilesVO == memberFilesVO2);
		 */
		/*
		 * MemberFilesVO memberFilesVO = new MemberFilesVO();
		 * memberFilesVO.setId("admin"); memberFilesVO.setFname("admin.jpg");
		 * memberFilesVO.setOname("admin.jpg");
		 * memberFilesRepository.save(memberFilesVO);
		 */

		
		 
		/*
		 * String a = memberFilesRepository.findById("aaa").getOname();
		 * System.out.println("Oname:"+ a);
		 */
		
		List<MemberFilesVO> ar = memberFilesRepository.findById("aaa");
		for(MemberFilesVO memberFilesVO:ar) {
			System.out.println(memberFilesVO.getId());
			System.out.println(memberFilesVO.getOname());
		}
		 	
		 	
		 	
	
	}

}
