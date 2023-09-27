package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.MemberFileComponent;
import com.itbank.component.HashComponent;
import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberFileComponent fileComponent;
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

	public MemberDTO isPw(HashMap<String, String> param) {
		String userid = param.get("userid");
		MemberDTO dto = memberDAO.selectOneById(userid);

		String loginPw = dto.getUserpw();
		String loginSalt = dto.getSalt();
		String inputPw = param.get("inputPw");
		
		String inputHash = hashComponent.getHash(inputPw, loginSalt);
		if(inputHash.equals(loginPw)) {
			return dto;
		}
		return null;
		
	}

	public int memberUpdate(MemberDTO dto) {
		MemberDTO login = memberDAO.selectOneByIdx(dto.getIdx());
		String currentFileName = login.getFileName();		// 현재 파일 이름을 가져와서
		String fileName = "";
		int row = 0;
		if(login != null) {				
			if(dto.getUpload().getSize() != 0) {					// 수정할 파일이 들어왔으면
				if(currentFileName != "image.jpg") {				// 현재 파일 이름이 기본 이미지가 아니라면
				fileComponent.removeFile(currentFileName);			// 삭제하고
				}
			fileName += fileComponent.upload(dto.getUpload());		// 파일 이름을 새로 생성해주고	
				
			}
			else {									// 수정할 파일이 들어오지 않았으면
				fileName += currentFileName;		// 파일 이름에 현재 파일 이름을 그대로 넣어준다
			}
		
			String salt = hashComponent.getRandomSalt();
			String hash = hashComponent.getHash(dto.getUserpw(), salt);
			dto.setFileName(fileName);
			dto.setSalt(salt);
			dto.setUserpw(hash);
			row = memberDAO.memberUpdate(dto);			
		}
		return row;
	}

	public int memberDelete(HashMap<String, String> param) {
		int row = 0;
		String userid = param.get("userid");
		MemberDTO dto = memberDAO.selectOneById(userid);

		String loginPw = dto.getUserpw();
		String loginSalt = dto.getSalt();
		String inputPw = param.get("inputPw");
		
		String inputHash = hashComponent.getHash(inputPw, loginSalt);
		if(inputHash.equals(loginPw)) {
			String fileName = dto.getFileName();
			fileComponent.removeFile(fileName);
			return memberDAO.memberDelete(param);
		}
		return row;
	}

	public MemberDTO selectOneByIdx(int idx) {
		MemberDTO dto = memberDAO.selectOneByIdx(idx);
		return dto;
	}

	public List<BoardDTO> selectBoardByIdx(int idx) {
		List<BoardDTO> list = memberDAO.selectBoardByIdx(idx);
		return list;
	}
	
	
}
