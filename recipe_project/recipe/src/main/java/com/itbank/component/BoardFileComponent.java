package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BoardFileComponent {
	
	private String saveDirectory="C:\\recipe";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public BoardFileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) {
		if(f.getSize() != 0) {
		String fileName = sdf.format(new Date()) + "_" + f.getOriginalFilename();
		
		File dest = new File(saveDirectory, fileName);
			try {
				f.transferTo(dest);
			} catch (IllegalStateException e) { //멀티로 예외처리하고 싶은데 자꾸 에러뜸
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return fileName;
		}
		return null;
	}
	
	public void deleteFile(String fileName) {
		File dest = new File(saveDirectory, fileName);
		if(dest.exists()) {
			dest.delete();
		}
	}

	public void removeFile(String fileName) {
		File dest = new File(saveDirectory, fileName);
		if(dest.exists()) {
			System.out.println(dest.delete());
			
		}
		
	}
}
