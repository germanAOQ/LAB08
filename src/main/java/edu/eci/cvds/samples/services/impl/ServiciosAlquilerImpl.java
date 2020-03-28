package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISClienteDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;


@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   @Inject
   private ClienteDAO clienteDAO;
   //@Inject
   //private TipoItemDAO tipoItemDAO;
   @Inject
   private ItemRentadoDAO itemRentadoDAO;


   @Override
   public int valorMultaRetrasoxDia(int itemId){
	   return itemDAO.consultarValorMulta(itemId);
	   
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
	   int id = (int) docu;
	   return clienteDAO.load(id);
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
       Cliente cliente = consultarCliente(idcliente);
       return cliente.getRentados();
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
       return clienteDAO.consultarCliente();
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() {
       return itemDAO.consultarItems();
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
	   int multa = itemDAO.consultarValorMulta(iditem);
	   Date fechaFin = itemDAO.consultarFechaFinItemRentado(iditem);
       int dias = (int) ((fechaDevolucion.getTime()-fechaFin.getTime())/86400000);
       return multa*dias;
       
       
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       try {
		return itemDAO.load(id).getTipo();
	} catch (PersistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;		
	}
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); 	
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	   Calendar calendar = Calendar.getInstance();
	   calendar.setTime(date);
	   calendar.add(Calendar.DAY_OF_YEAR, numdias);
       itemRentadoDAO.insertarItemRentado((int)docu, date , (Date) calendar.getTime(), item.getId());
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
	   int vetado;
	   if(c.isVetado()){
		   vetado=0;
	   }else {
		   vetado=1;
	   }
       clienteDAO.saveCliente((int) c.getDocumento(), c.getNombre(), c.getTelefono(), c.getDireccion(), c.getEmail(), vetado);
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
	   long res = 0;
	   try {
		   Item temp = itemDAO.load(iditem);
		   res = temp.getTarifaxDia()*numdias;
	   } catch (PersistenceException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   return res;

   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       itemDAO.actualizarTarifa(id, (int) tarifa);
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
	   try {
		itemDAO.save(i);
	} catch (PersistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
	   int vet = 0;
	   if(estado) vet = 1;
	   clienteDAO.actualizarVetado((int)docu, vet);
   }
}