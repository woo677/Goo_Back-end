package kr.co.gudi.dto;

import javax.xml.crypto.Data;

import org.apache.ibatis.type.Alias;

@Alias("board")
public class BoardDTO {

	private int idx;
	private String user_name;
	private String subject;
	private String content;
	private int bHit;
	private Data reg_date;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public Data getReg_date() {
		return reg_date;
	}
	public void setReg_date(Data reg_date) {
		this.reg_date = reg_date;
	}
}
