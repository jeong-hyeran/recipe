package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired private BoardService boardService;
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto, HttpSession session) {
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if(login != null) {
		dto.setMember_idx(login.getIdx());
//		dto.setMember_username(login.getUsername());
		}
		int idx = boardService.insertBoard(dto);
		System.out.println(idx + "번 글이 추가되었습니다.");
//		return "redirect:/board/list";
		return "redirect:/";
	}
	
}
