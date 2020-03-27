package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {

	public void save(String produc);
	
	public TipoItem load(int id);
}
