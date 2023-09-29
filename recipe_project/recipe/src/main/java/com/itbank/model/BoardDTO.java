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
	private List<String> ingrs;
	private String ingr;
	private String fileName;
	private List<MultipartFile> upload;
	private Date wdate;
	private int viewCount;
	private int likeCount;
	
	private String member_fileName;
	private String member_userid;
	private String member_username;
	
	public final int getIdx() {
		return idx;
	}
	public final void setIdx(int idx) {
		this.idx = idx;
	}
	public final int getMember_idx() {
		return member_idx;
	}
	public final void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final List<String> getContents() {
		return contents;
	}
	public final void setContents(List<String> contents) {
		this.contents = contents;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final List<String> getIngrs() {
		return ingrs;
	}
	public final void setIngrs(List<String> ingrs) {
		this.ingrs = ingrs;
	}
	public final String getIngr() {
		return ingr;
	}
	public final void setIngr(String ingr) {
		this.ingr = ingr;
	}
	public final String getFileName() {
		return fileName;
	}
	public final void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public final List<MultipartFile> getUpload() {
		return upload;
	}
	public final void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
	public final Date getWdate() {
		return wdate;
	}
	public final void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public final int getViewCount() {
		return viewCount;
	}
	public final void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public final int getLikeCount() {
		return likeCount;
	}
	public final void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public final String getMember_fileName() {
		return member_fileName;
	}
	
	public final void setMember_fileName(String member_fileName) {
		this.member_fileName = member_fileName;
	}
	public final String getMember_userid() {
		return member_userid;
	}
	public final void setMember_userid(String member_userid) {
		this.member_userid = member_userid;
	}
	public final String getMember_username() {
		return member_username;
	}
	public final void setMember_username(String member_username) {
		this.member_username = member_username;
	}
	
	

}