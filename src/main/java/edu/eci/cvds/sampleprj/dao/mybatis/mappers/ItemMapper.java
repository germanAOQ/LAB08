package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("itid") int id);
    
    public void insertarItem(Item it);

	public void insertarItem(@Param("id") int id,@Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("fechaLanzamiento") Date fechalanzamiento,@Param("tarifaxDia") long l,@Param("formatoRenta") String formatorenta,@Param("genero") String genero,@Param("tipo_id") int tipoItem);

	public Item consultarValorMulta(@Param("itemid") int itemId);
	
	public ArrayList consultarItemRentado(@Param("itid") int ip);
	
	public void updateTarifaDia(@Param("id")int id,@Param("txd") int tarifa);
        
}