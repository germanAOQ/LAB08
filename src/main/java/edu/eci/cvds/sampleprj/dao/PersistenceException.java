package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class PersistenceException extends Exception{
	public PersistenceException() {
		
	}
	
	public PersistenceException(String msg, org.apache.ibatis.exceptions.PersistenceException e) {
		super(msg);
	}
}
