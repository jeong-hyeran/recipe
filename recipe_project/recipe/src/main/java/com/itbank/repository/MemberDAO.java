package com.itbank.repository;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	int insertMember(MemberDTO user);

	MemberDTO selectOneById(String userid);


}
