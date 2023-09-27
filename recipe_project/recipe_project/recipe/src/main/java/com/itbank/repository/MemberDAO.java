package com.itbank.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	int insertMember(MemberDTO user);

	MemberDTO selectOneById(String userid);

	int memberUpdate(MemberDTO dto);

	MemberDTO selectOneByIdx(int idx);

	int memberDelete(HashMap<String, String> param);


}
