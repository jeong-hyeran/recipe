package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private FileComponent fileComponent;
	@Autowired private BoardDAO boardDAO;
	public int insertBoard(BoardDTO dto) {
		String fileName = fileComponent.upload(dto.getUpload());
		dto.setFileName(fileName);
		int idx = boardDAO.insertBoard(dto);
		return idx;
	}
	
	
}
