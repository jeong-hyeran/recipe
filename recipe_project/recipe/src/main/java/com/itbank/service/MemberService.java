package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private FileComponent fileComponent;
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	public int join(MemberDTO dto) {
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		String fileName = fileComponent.upload(dto.getUpload());
		dto.setFileName(fileName);
		return memberDAO.insertMember(dto);
	}

	public MemberDTO selectOneById(MemberDTO dto) {
		MemberDTO login = memberDAO.selectOneById(dto.getUserid());
		if (login != null) {
			String oldHash = login.getUserpw(); // 가입되어있는 정보 중 hash
			String newHash = hashComponent.getHash(dto.getUserpw(), login.getSalt());
				if(oldHash.equals(newHash)) {
					return login;
				}
		}
		return null;
	}
	
	
}
