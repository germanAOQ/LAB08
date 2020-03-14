package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.Date;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public class MyBATISClienteDAO implements ClienteDAO{

	@Override
	public void save(int ipd, int id, int idit, Date fechainicio, Date fechafin) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente load(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
