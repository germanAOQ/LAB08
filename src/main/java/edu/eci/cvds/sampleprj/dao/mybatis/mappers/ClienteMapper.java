package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") int id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idpr") int ipd, @Param("idcli")int id,@Param("idit") int idit,@Param("fein") Date fechainicio,@Param("fefn") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
    public void insertarCliente(@Param("doc")int documento,@Param("nom") String nombre, @Param("tel")String telefono,@Param("dir") String direccion,@Param("vet") int vetado);
    
    public void updateVetado(@Param("id")int id,@Param("vet") int vetado);
    
}
