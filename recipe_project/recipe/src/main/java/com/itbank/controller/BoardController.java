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
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx, BoardDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/board/view/{idx}");
		int row = boardService.boardUpdate(dto);
		System.out.println(row + "행이 업데이트 되었습니다");
		return mav;
	}
	
	@GetMapping("delete/{idx}")
	public String delete(@PathVariable("idx")int idx) {
		BoardDTO dto = boardService.selectOne(idx);
		int row = boardService.boardDelete(dto);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/board/list";
	}
	
	
}
