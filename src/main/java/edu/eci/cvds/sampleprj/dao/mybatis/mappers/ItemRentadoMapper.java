package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

public interface ItemRentadoMapper {
	
	public void insertarItemRentado(@Param("id") int id,@Param("cliente")int cliente, @Param("item")int item, @Param("fechainiciorenta")Date fechainicio,@Param("fechafinrenta")Date fechafin);
	
	public void insertarItemRentadoD(@Param("cliente")int cliente, @Param("item")int item, @Param("fechainiciorenta")Date fechainicio,@Param("fechafinrenta")Date fechafin);


}
