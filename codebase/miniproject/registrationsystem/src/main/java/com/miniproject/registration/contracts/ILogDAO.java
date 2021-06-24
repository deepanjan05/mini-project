package com.miniproject.registration.contracts;

import java.util.List;

import com.miniproject.registration.entity.LogData;

public interface ILogDAO {
	/* Basic CRUD */
	public boolean insertLog(LogData log);
	public LogData getLog(int logId);
	public boolean deleteLog(int logId);
	
	/* Miscellaneous */
	public List<LogData> getAllLogs();
}
