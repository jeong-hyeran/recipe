package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		System.out.println(row + "행이 추가되었습니다.");
		return "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto,HttpSession session) {
		MemberDTO login = memberService.selectOneById(dto);
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
	
	@GetMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		if(login != null) {
			List<BoardDTO> list = memberService.selectBoardByIdx(login.getIdx());			
			mav.addObject("list", list);
		}
		return mav;
	}
	
	@GetMapping("/updateCon")
	public String update() {
		return "member/passCon";
	}
	
	@PostMapping("/updateCon")
	public ModelAndView update(@RequestParam HashMap<String, String> param, HttpSession session) {
		ModelAndView mav = new ModelAndView("msg");
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		String inputPw = param.get("currentPw");
		String userid = login.getUserid();
		
		param.put("inputPw", inputPw);
		param.put("userid", userid);
		MemberDTO dto = memberService.isPw(param);
		if(dto != null) {
			mav.setViewName("/member/update");
			return mav;
		}
		mav.addObject("msg", "비밀번호를 다시 확인해주세요");
		return mav;
	}
	
	@PostMapping("update/{idx}")
	public String update(@PathVariable("idx")int idx, MemberDTO dto) {
		dto.setIdx(idx);
		int row = memberService.memberUpdate(dto);
		System.out.println(row + "행이 업데이트 되었습니다");
		return "redirect:/member/logout";
	}
	
	@GetMapping("deleteCon")
	public String delete() {
		return "member/passCon";
	}
	
	@PostMapping("deleteCon")
	public ModelAndView delete(@RequestParam HashMap<String, String> param, HttpSession session) {
		ModelAndView mav = new ModelAndView("msg");
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		String inputPw = param.get("currentPw");
		String userid = login.getUserid();
		
		param.put("inputPw", inputPw);
		param.put("userid", userid);
		int row = memberService.memberDelete(param);
		System.out.println(row + "행이 삭제되었습니다");
		if(row != 0) {
			mav.setViewName("redirect:/member/logout");
			return mav;
		}
		mav.addObject("msg", "비밀번호를 다시 확인해주세요");
		return mav;
	}
	
	@GetMapping("view/{member_idx}")
	public ModelAndView view(@PathVariable("member_idx") int idx) {
		ModelAndView mav = new ModelAndView("member/view");
		MemberDTO dto = memberService.selectOneByIdx(idx);
		List<BoardDTO> list = memberService.selectBoardByIdx(idx);
		
		mav.addObject("dto", dto);
		mav.addObject("list", list);
		return mav;
	}
}
	
	
