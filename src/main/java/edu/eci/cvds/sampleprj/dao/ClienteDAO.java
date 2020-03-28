package edu.eci.cvds.sampleprj.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public interface ClienteDAO {

   public void save(int ipd, int id, int idit, Date fechainicio, Date fechafin) throws PersistenceException;

   public abstract Cliente load(int id) throws PersistenceException;
   
   public abstract List<Cliente> consultarCliente();
   
   public void saveCliente(int documento, String nombre, String telefono, String direccion, String email, int vetado);
   
   public void actualizarVetado(int id, int vetado);

}