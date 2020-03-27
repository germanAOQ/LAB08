package edu.eci.cvds.sampleprj.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.samples.entities.Item;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws PersistenceException;
   
   public abstract int consultarValorMulta(int id);
   
   public abstract List<Item> consultarItems();
   
   public abstract Date consultarFechaFinItemRentado(int idItem);

}