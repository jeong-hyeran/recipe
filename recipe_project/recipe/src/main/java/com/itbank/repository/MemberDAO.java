package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	int insertMember(MemberDTO user);

	MemberDTO selectOneById(String userid);

	int memberUpdate(MemberDTO dto);

	int memberDelete(HashMap<String, String> param);

	MemberDTO selectOneByIdx(int idx);

	List<BoardDTO> selectBoardByIdx(int idx);

	


}
