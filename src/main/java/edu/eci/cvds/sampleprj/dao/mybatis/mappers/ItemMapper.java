package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(int id);
    
    //public void insertarItem(Item it);

	public void insertarItem(@Param("id") int id,@Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("fechaLanzamiento") Date fechalanzamiento,@Param("tarifaxDia") int tarifaxdia,@Param("formatoRenta") String formatorenta,@Param("genero") String genero,@Param("tipo_id") int TIPOITEM_id);

        
}