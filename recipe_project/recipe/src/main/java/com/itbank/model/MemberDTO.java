package com.itbank.model;
/*
     idx                 number          default member_seq.nextval primary key,
    userid              varchar2(100)   not null unique,
    userpw              varchar2(300)   not null,
    username            varchar2(100)   not null,
    email               varchar2(100)   not null,
    fileName            varchar2(300)   default 'image.jpg',
    salt                varchar2(100)   not null,
    memo                varchar2(200)   default '안녕하세요'
);
  */

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {

	private int idx;
	private String userid;
	private String userpw;
	private String salt;
	private String username;
	private String email;
	private String fileName;
	private MultipartFile upload;
	private String memo;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
