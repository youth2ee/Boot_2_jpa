package com.iu.b1.member;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	public List<MemberVO> memberLogin(MemberVO memberVO)throws Exception{
		List<MemberVO> ar = memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		return ar; 
	}
	
	public List<MemberFilesVO> memberFilesSelect(MemberFilesVO memberFilesVO) throws Exception{
		List<MemberFilesVO> ar = memberFilesRepository.findById(memberFilesVO.getFname());
		return ar;
	}
	
	public MemberVO memberJoin(MemberVO memberVO) throws Exception{
		
		
		memberVO = memberRepository.save(memberVO);
		
		
		
		return memberVO;
	}
	
	public Boolean idCheck(MemberVO memberVO) throws Exception {
		return memberRepository.existsById(memberVO.getId());
	}
	
	

}
