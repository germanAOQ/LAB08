/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {

        SqlSessionFactory sessionfact = getSqlSessionFactory();
        
		//Crear el mapper y usarlo:
        SqlSession sqlss = sessionfact.openSession();
        //Crear el mapper y usarlo:
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        ItemMapper im=sqlss.getMapper(ItemMapper.class);
		
        //cm 
        System.out.println(cm.consultarClientes());
        //Consulta usuario Roberto

        System.out.println(cm.consultarCliente(447744114));
        Date date1 = null;
        Date date2 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");
			date2 = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1999");
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		//cm.agregarItemRentadoACliente(2132623,-33, 2, date1, date2);
        im.insertarItem(111111, "Tapabocas", "Prevenir esparcimiento de particulas",date1 ,10,"prueba", "aseo",2);
        sqlss.commit();

        
        
    }


}
