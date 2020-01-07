package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberRepositoryTest {
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void test() throws Exception {
		//long count = memberRepository.count();
		//boolean check = memberRepository.existsById("admin");
		//List<MemberVO> ar = memberRepository.findAll();
		//for(MemberVO memberVO:ar) {
		//	System.out.println(memberVO.getId());
		//}
		
		/*
		 * Optional<MemberVO> op = memberRepository.findById("adminqwe ");
		 * if(op.isPresent()) { MemberVO memberVO = op.get();
		 * System.out.println(memberVO.getEmail()); }else {
		 * System.out.println("NO DATA"); }
		 */
		//save 는 insert update 둘다 함
		//MemberVO memberVO = new MemberVO();
		//memberVO.setId("iu20");
		//memberVO.setPw("iu20");
		//memberVO.setEmail("iu20@iu");
		//memberVO.setName("rename");
		//memberRepository.save(memberVO);
		
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("aaa");
		memberVO.setPw("aaa");
		memberVO.setName("aaa");
		
		List<MemberVO> ar = memberRepository.findByIdAndPw("aaa", "aaa");
		if(ar==null) {
			System.out.println("sssssss");
		}else {
			System.out.println("aaaaaaa");
		}
		
		
		
		
	}

}
