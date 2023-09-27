package com.itbank.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itbank.component.BoardFileComponent;
import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardFileComponent fileComponent;
	@Autowired private BoardDAO boardDAO;
	public int insertBoard(BoardDTO dto) {
	
		String s ="";
		for (int i = 0; i < dto.getContents().size(); i++) {
			s += dto.getContents().get(i);
			if(i != dto.getContents().size() -1 ) {
				s += ",";
			}
		}
		System.out.println(s);
		dto.setContent(s);
		
		String file ="";
		for (int i = 0; i < dto.getUpload().size(); i++) {
			String fileName = fileComponent.upload(dto.getUpload().get(i));
			file += fileName;
			if(i != dto.getContents().size() -1 ) {
				file += ",";
			}
		}
		System.out.println(file);
		dto.setFileName(file);
		
		boardDAO.insertBoard(dto);
		int idx = boardDAO.maxIdx();
		return idx;
	}
	
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = boardDAO.selectAll();
		return list;
	}
	
	public BoardDTO selectOne(int idx) {
		BoardDTO dto = boardDAO.selectOne(idx);
		return dto;
	}
	
	// 내용을 콤마 기준으로 잘라서 배열로 만든 뒤 리스트로 반환해주는 메서드
	public List<String> getContentList(BoardDTO dto) {
		String[] content = dto.getContent().split(",");
		List<String> contentList = Arrays.asList(content);
		return contentList;
	}
	
	// 파일 이름을 콤마 기준으로 잘라서 배열로 만든 뒤 리스트로 반환해주는 메서드
	public List<String> getFileNameList(BoardDTO dto) {
		String[] fileName = dto.getFileName().split(",");
		List<String> fileNameList = Arrays.asList(fileName);
		return fileNameList;
	}
	
	

	
	
}