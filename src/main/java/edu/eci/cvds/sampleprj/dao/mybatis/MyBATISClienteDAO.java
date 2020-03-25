package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.Date;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public class MyBATISClienteDAO implements ClienteDAO{

	private ClienteMapper clienteMapper;
	@Override
	public void save(int ipd, int id, int idit, Date fechainicio, Date fechafin) throws PersistenceException {
		clienteMapper.agregarItemRentadoACliente(ipd, id, idit, fechainicio, fechafin);
	}

	@Override
	public Cliente load(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return clienteMapper.consultarCliente(id);
	}
	
}
