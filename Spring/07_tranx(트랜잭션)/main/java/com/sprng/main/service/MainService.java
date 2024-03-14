package com.sprng.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sprng.main.dao.MainDao;

public class MainService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insert() {

		MainDao dao = new MainDao();

		dao.insert();
		
		
	}
}
