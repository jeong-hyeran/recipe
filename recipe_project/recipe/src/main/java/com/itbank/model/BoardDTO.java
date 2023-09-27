package com.itbank.model;
/*   
  	idx                 number          default board_seq.nextval primary key,
    member_idx          number          not null,
    title               varchar2(100)   not null,
    content             varchar2(4000)  not null,
    fileName            varchar2(300)   not null,
    wdate               date            default sysdate,
    viewCount           number          default 0,
    likeCount           number          default 0,
    */

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {

	private int idx;
	private int member_idx;
	private String title;
	private List<String> contents;
	private String content;
	private String fileName;
	private List<MultipartFile> upload;
	private Date wdate;
	private int viewCount;
	private int likeCount;
	
	private String member_fileName;
	private String member_userid;
	private String member_username;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<MultipartFile> getUpload() {
		return upload;
	}
	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getMember_userid() {
		return member_userid;
	}
	public void setMember_userid(String member_userid) {
		this.member_userid = member_userid;
	}
	public String getMember_username() {
		return member_username;
	}
	public void setMember_username(String member_username) {
		this.member_username = member_username;
	}
	public String getMember_fileName() {
		return member_fileName;
	}
	public void setMember_fileName(String member_fileName) {
		this.member_fileName = member_fileName;
	}
	
	
	

}