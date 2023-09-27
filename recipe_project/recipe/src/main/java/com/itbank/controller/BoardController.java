package com.itbank.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		}
		int idx = boardService.insertBoard(dto);
		System.out.println(idx + "번 글이 추가되었습니다.");
		return "redirect:/board/list";
	}
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = boardService.selectAll();
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("board/view");
		BoardDTO dto = boardService.selectOne(idx);
		
		List<String> contentList = boardService.getContentList(dto);
		List<String> fileNameList = boardService.getFileNameList(dto);
		
		mav.addObject("dto",dto);
		mav.addObject("contentList",contentList);
		mav.addObject("fileNameList",fileNameList);
		System.out.println(fileNameList);
		return mav;
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("board/update");
		BoardDTO dto = boardService.selectOne(idx);
		
		List<String> contentList = boardService.getContentList(dto);
		List<String> fileNameList = boardService.getFileNameList(dto);
		mav.addObject("dto", dto);
		mav.addObject("contentList", contentList);
		mav.addObject("fileNameList", fileNameList);
		return mav;
	}
	// 검색어가 하나일 경우 검색
	@PostMapping("/search")
	public ModelAndView search(String keyword) {
		ModelAndView mav = new ModelAndView("board/searchList");
		if(keyword != null) {
			List<BoardDTO> list = boardService.search(keyword);
			mav.addObject("list",list);
			mav.addObject("keyword",keyword);
			return mav;
		}
		return null;
	}
//	@GetMapping("/searchList")
//	public void excludeSearch() {};
	// 제어할 검색어가 있을때
	@PostMapping("/searchList")
	public ModelAndView excludeSearch(String keyword, String excludeKeyword) {
		ModelAndView mav = new ModelAndView("board/searchList");
		if(keyword != null && excludeKeyword != null) {
			List<BoardDTO> list = boardService.excludeSearch(keyword, excludeKeyword);
			mav.addObject("list",list);
			mav.addObject("excludeKeyword",excludeKeyword);
			mav.addObject("keyword",keyword);
			return mav;
		}
		return null;
	}
	
}
