package com.springweb.service;

import com.springweb.dto.LoginLog;
import com.springweb.util.datasource.DataSource;

public interface ILoginLogService {

	@DataSource("master")
	public void insertLog(LoginLog log);
	
}
