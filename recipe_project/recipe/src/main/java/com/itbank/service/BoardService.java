package com.itbank.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
		
	    String s = "";
	    for (int i = 0; i < dto.getContents().size(); i++) {
	        s += dto.getContents().get(i);
	        if (i != dto.getContents().size() - 1) {
	            s += "|"; // ,를 |로 대체
	        }
	    }
	    System.out.println(s);
	    dto.setContent(s);

	    String file = "";
	    for (int i = 0; i < dto.getUpload().size(); i++) {
	        String fileName = fileComponent.upload(dto.getUpload().get(i));
	        file += fileName;
	        if (i != dto.getContents().size() - 1) {
	            file += "|"; // ,를 |로 대체
	        }
	    }
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
		int viewCount = boardDAO.viewCount(idx);
		dto.setViewCount(viewCount);
		return dto;
	}
	
	// 내용을 | 기준으로 잘라서 배열로 만든 뒤 리스트로 반환해주는 메서드
	public List<String> getContentList(BoardDTO dto) {
	    String[] content = dto.getContent().split("\\|"); // |를 ,로 복원
	    List<String> contentList = Arrays.asList(content);
	    return contentList;
	}

	// 파일 이름을 | 기준으로 잘라서 배열로 만든 뒤 리스트로 반환해주는 메서드
	public List<String> getFileNameList(BoardDTO dto) {
	    String[] fileName = dto.getFileName().split("\\|"); // |를 ,로 복원
	    List<String> fileNameList = Arrays.asList(fileName);
	    return fileNameList;
	}

	public int boardUpdate(BoardDTO dto) {
		List<MultipartFile> uploadList = dto.getUpload();
		List<String> contentList = dto.getContents();
		
		// cotent
		String content = "";
		for(int i = 0; i < contentList.size(); i++) {
			content += contentList.get(i);
			if(i != contentList.size() - 1) {
				content += ",";
			}
		}
		
		// fileName
		String fileName = "";
		// 수정할때 form에서 파일을 선택안하면 null이 들어가기 때문에
		// 원래 파일 이름을 가져오기 위해서 selectOne을 사용함
		BoardDTO curr = boardDAO.selectOne(dto.getIdx());
		String currentFile = curr.getFileName();
		String[] arr = currentFile.split(",");
		
		System.out.println(currentFile);
		
		for(int i = 0; i < uploadList.size(); i++) {
			if(uploadList.get(i).getSize() == 0) {
				fileName += arr[i];
			}
			else {
				String file = fileComponent.upload(uploadList.get(i));
				fileName += file;
			}
			if(i != uploadList.size() - 1) {
				fileName += ",";								
			}
		}
		dto.setContent(content);
		dto.setFileName(fileName);
		System.out.println(fileName);
		System.out.println();
		
		return boardDAO.boardUpdate(dto);
	}

	public int boardDelete(BoardDTO dto) {
	      String fileName = dto.getFileName();
	      String[] arr = fileName.split(",");
	      for(int i = 0; i < arr.length; i++) {
	         fileComponent.removeFile(arr[i]);
	      }
	      return boardDAO.boardDelete(dto.getIdx());
	   }
	
	// 검색어가 하나일 경우 검색
	public List<BoardDTO> search(String keyword) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		System.out.printf("키워드는 %s", keyword);
		list = boardDAO.search(keyword);
		return list;
	}

	// 검색어가 여러개일 경우 검색
	public List<BoardDTO> searches(String keyword) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		// keyword를 [,]기준으로 나눠서 배열로 담기
		String[] keywords = keyword.split(",");
		
		for (int i = 0; i < keywords.length; i++) {
			String searchKeyword = keywords[i];
			List<BoardDTO> searchResult = boardDAO.searches(searchKeyword);
	        list.addAll(searchResult); 
		}
		return list;
	}
	
	// 제외하는 검색어가 하나일 경우 검색
	public List<BoardDTO> excludeSearch(String excludeKeyword) {
		List<BoardDTO> list = new ArrayList<BoardDTO>(); 
		list = boardDAO.excludeSearch(excludeKeyword);
		return list;
	}
	
	
	// 제외할 검색어가 있을때
	public List<BoardDTO> excludeSearchUP(String keyword, String excludeKeyword) {
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("excludeKeyword", excludeKeyword);
		List<BoardDTO> list = boardDAO.excludeSearchUP(map);
		
		return list;
	}

	
	
}