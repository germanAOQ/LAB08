package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

public class MyBATISTipoItemDAO implements TipoItemDAO{
	
	private TipoItemMapper tipoItemMapper;
	
	public void save(String produc) {
		tipoItemMapper.addTipoItem(produc);;
	}
	
	public TipoItem load(int id) {
		return tipoItemMapper.getTipoItem(id);
	}

}
