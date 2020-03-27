package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

import java.awt.List;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyBATISItemDAO implements ItemDAO{

	@Inject
	private ItemMapper itemMapper;    

	@Override
	public void save(Item it) throws PersistenceException{
		try{
			itemMapper.insertarItem(it);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el item "+it.toString(),e);
		}        

	}

	@Override
	public Item load(int id) throws PersistenceException {
		try{
			return itemMapper.consultarItem(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el item "+id,e);
		}




	}

	@Override
	public int consultarValorMulta(int id){
		return (int) itemMapper.consultarValorMulta(id).getTarifaxDia();
	}

	@Override
	public java.util.List<Item> consultarItems() {
		return itemMapper.consultarItems();
	}

	@Override
	public Date consultarFechaFinItemRentado(int idItem) {
		return (Date) itemMapper.consultarItemRentado(idItem).get(0);
	}



}