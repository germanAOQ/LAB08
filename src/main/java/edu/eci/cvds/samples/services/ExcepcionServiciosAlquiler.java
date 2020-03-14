package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception{
	public static String CLIENTE_NO_REGISTRADO="El cliente no está registrado";
	public static String ITEM_INEXISTENTE = "si el item no existe o no está actualmente alquilado";
	public static String ITEM_NO_CORRESPONDE = "si el identificador no corresponde con un item, o el mismo ya esta alquilado";
	public static String ITEM_ID_INEXISTENTE = "si el identificador del item no existe";
	public ExcepcionServiciosAlquiler(String msg) {
		super(msg);
	}



	public ExcepcionServiciosAlquiler(String msg, PersistenceException ex) {
		super(msg);
	}}
