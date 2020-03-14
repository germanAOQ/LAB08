package edu.eci.cvds.sampleprj.dao;

import java.util.Date;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Item;

public interface ClienteDAO {

   public void save(int ipd, int id, int idit, Date fechainicio, Date fechafin) throws PersistenceException;

   public Cliente load(int id) throws PersistenceException;

}