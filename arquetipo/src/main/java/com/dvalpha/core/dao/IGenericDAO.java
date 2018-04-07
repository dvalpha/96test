package com.dvalpha.core.dao;

import java.util.List;

public interface IGenericDAO {
	
	//Operaciones CRUD
	public void   createEntity(Object obj);
	public Object readById(Long id,Class clase);
	public void updateEntity(Object obj);
	public void   deleteEntity(Object obj);
	
	//Listas genericas por atributos
	
	public List<?> findAll(Object entity);
	public List<?> findAllWhere(Object entity,String campo,Object valor);
	
	
	public void updateWhere(Object entity, String campo1, Integer valor1, String campo2, Long valor2);
	List<?> findAllSimple(Object entity);
	List<?> findAllWhereAnd(Object entity, String campo, Object valor, String campoand, Object valorand);
	public  List<?> find_By_SQL_Generic(String sql,Class clase);
	List<?> find_By_SQL_Generic(String sql);
	
}
