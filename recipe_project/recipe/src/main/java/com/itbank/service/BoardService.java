package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.component.BoardFileComponent;
import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardFileComponent fileComponent;
	@Autowired private BoardDAO boardDAO;
	public int insertBoard(BoardDTO dto) {
		for( MultipartFile f : dto.getUpload()) {
			String fileName = fileComponent.upload(f);
			dto.setFileName(fileName);
		}
		boardDAO.insertBoard(dto);
		int idx = boardDAO.maxIdx();
		return idx;
	}
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = boardDAO.selectAll();
		return list;
	}

	
	
}
