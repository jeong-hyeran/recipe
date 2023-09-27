package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	int insertBoard(BoardDTO dto);

	List<BoardDTO> selectAll();

	int maxIdx();

	BoardDTO selectOne(int idx);

	int boardUpdate(BoardDTO dto);

	int boardDelete(int idx);

}
