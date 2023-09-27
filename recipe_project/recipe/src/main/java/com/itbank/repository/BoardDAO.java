package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	int insertBoard(BoardDTO dto);

	List<BoardDTO> selectAll();

	int maxIdx();

	BoardDTO selectOne(int idx);

	List<BoardDTO> search(String keyword);

	List<BoardDTO> excludeSearch(HashMap<String, String> map);



}
