package com.iu.b1.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;

	
	/*
	 * @GetMapping("memberFileDown") public ModelAndView
	 * memberFileDown(MemberFilesVO memberFilesVO) throws Exception { ModelAndView
	 * mv = new ModelAndView(); List<MemberFilesVO> ar =
	 * memberService.memberFilesSelect(memberFilesVO);
	 * 
	 * if (ar.size() != 0) { mv.addObject("memberfiles", ar); mv.addObject("path",
	 * "upload"); mv.setViewName("fileDown"); } else { mv.addObject("message",
	 * "no Image"); mv.addObject("path", "./myPage");
	 * mv.setViewName("common/result"); } return mv; }
	 */

	@ModelAttribute
	public MemberVO getMemberVO() throws Exception {
		return new MemberVO();
	}

	@GetMapping("memberJoin")
	public String memberJoin(/* Model model */) throws Exception {
		/*
		 * MemberVO memberVO = new MemberVO model.addAttribute("memberVO", new
		 * MemberVO());
		 */
		return "member/memberJoin";

	}

	// valid 검증 후 그 뒤에 바로 bindingResult 써줘야함(순서 중요)
	
	/*
	 * @PostMapping("memberJoin") public ModelAndView memberJoin(@Valid MemberVO
	 * memberVO, BindingResult bindingResult, MultipartFile file) throws Exception {
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * memberVO = memberService.memberJoin(memberVO, file);
	 * 
	 * 
	 * return mv;
	 * 
	 * }
	 */
	 
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile file) throws Exception {
		ModelAndView mv = new ModelAndView();
		String msg = "가입실패";
		String path = "../";
		
		if(!memberService.idCheck(memberVO)) {
			memberVO = memberService.memberJoin(memberVO);	
			msg = "가입성공";
			
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		
		return mv;

	}
	 
	
	
	 

	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {

	}

	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<MemberVO> ar = memberService.memberLogin(memberVO);

		String message = "Login Fail";
		if (ar.size() != 0) {
			message = "Login Success";
			session.setAttribute("member", ar.get(0));
		} else {

		}

		mv.addObject("message", message);
		mv.addObject("path", "../");
		mv.setViewName("common/result");

		return mv;
	}

	@GetMapping("myPage")
	public ModelAndView myPage(MemberFilesVO memberFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
	List<MemberFilesVO> ar = memberService.memberFilesSelect(memberFilesVO);
	if(ar.size() !=0) {
		mv.addObject("memberfiles", ar);
		mv.addObject("path","upload");
	}
	return mv;
	}

	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

}	
