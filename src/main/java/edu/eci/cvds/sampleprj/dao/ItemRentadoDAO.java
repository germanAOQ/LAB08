package edu.eci.cvds.sampleprj.dao;

import java.sql.Date;

import edu.eci.cvds.samples.entities.Item;

public interface ItemRentadoDAO {
	
	void insertarItem(int id, Date fechainicio, Date fechafin, int item);

}
