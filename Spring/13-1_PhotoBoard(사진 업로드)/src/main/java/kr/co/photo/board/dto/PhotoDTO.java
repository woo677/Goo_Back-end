package kr.co.photo.board.dto;

import java.sql.Date;

public class PhotoDTO {
	
	private int file_idx;
	private String ori_filname;
	private String new_filname;
	private Date reg_date;
	private int idx;
	
	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
	}
	public String getOri_filname() {
		return ori_filname;
	}
	public void setOri_filname(String ori_filname) {
		this.ori_filname = ori_filname;
	}
	public String getNew_filname() {
		return new_filname;
	}
	public void setNew_filname(String new_filname) {
		this.new_filname = new_filname;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

}
