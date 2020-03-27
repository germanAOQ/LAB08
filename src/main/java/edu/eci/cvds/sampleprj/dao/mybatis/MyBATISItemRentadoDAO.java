package edu.eci.cvds.sampleprj.dao.mybatis;

import java.sql.Date;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.Item;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

	@Inject
	ItemRentadoMapper itemRentadoMapper;

	@Override
	public void insertarItem(int id, Date fechainicio, Date fechafin, int item) {
		itemRentadoMapper.insertarItemRentado(id, fechainicio, fechafin, item);
	}
	

}
