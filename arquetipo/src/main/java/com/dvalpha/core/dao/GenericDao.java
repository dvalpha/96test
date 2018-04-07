package com.dvalpha.core.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metamodel.relational.Table;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvalpha.core.entity.MstCentro;

@Repository //al ser un DAO se ha de marcar con el estereotipo Repository
public class GenericDao extends AbstractDao<Integer, Object> implements IGenericDAO{

	/**
	 * CRUD General para operaciones básicas
	 */
	@Override
	@Transactional
	public void createEntity(Object obj) {
		abstractDaoInsertEntity(obj);	
	}
	@Override
	@Transactional
	public Object readById(Long id, Class clase) {
		
		return abstractDaoGetByKey(id,clase);
	}
	
	@Override
	@Transactional
	public void updateEntity(Object obj) {
        abstractDaoUpdate(obj);	
	}
	
	@Override
	@Transactional
	public void deleteEntity(Object obj) {
		abstractDaoDelete(obj);	
	}
	
	@Override
	@Transactional
	public List<?> findAll(Object entity) {
		
		Criteria crit = createEntityCriteria(entity.getClass());
		crit.addOrder(Order.asc("orden"));
		List<?>lista = crit.list();
		
		
		return lista;
		
	}
	
	@Override
	@Transactional
	public List<?> findAllSimple(Object entity) {
		
		Criteria crit = createEntityCriteria(entity.getClass());
		
		List<?>lista = crit.list();
		
		
		return lista;
		
	}
	
	@Override
	@Transactional
	public List<?> findAllWhere(Object entity,String campo,Object valor) {
		Criteria crit = createEntityCriteria(entity.getClass());
		crit.add( Restrictions.eq(campo, valor));
		
		List<?>lista = crit.list();
		return lista;
		
	}
	
	@Override
	@Transactional
	public List<?> findAllWhereAnd(Object entity,String campo,Object valor,String campoand,Object valorand) {
		
		Criteria crit = createEntityCriteria(entity.getClass());
		crit.add(Restrictions.eq(campo, valor));
		crit.add(Restrictions.and(Restrictions.eq(campoand, valorand)));
		
		List<?>lista = crit.list();
		return lista;
		
	}
	
	
	/**
     * Genera una lista a partir de una consulta sql nativa 
     * @param sql
     * @return 
     */
	@Override
	@Transactional
    public  List<?> find_By_SQL_Generic(String sql,Class clase){
	SQLQuery query = getSession().createSQLQuery(sql);
	query.addEntity(clase);
	List lista = query.list();
        return lista;
    }
	
	/**
	 * Metodo que devuelve el resultado de una consulta sql con un retorno de tipo 'NO Entity'
	 * por ejemplo un select MAX(id) from ..
	 * 
	 * Si lo que se tiene es un conjunto de campos la consulta devuelve una lista de tipo array object y para 
	 * acceder a sus valores ha de hacerse asi:
	 * 
	 * 
	 List<Object[]> lista = (List<Object[]>) dao.find_By_SQL_Generic(sql);
		for (Object[] elementos : lista){ 
		System.out.println(elementos[0]+" || "+elementos[1]+" || "+elementos[2]);
	}
	
	 */
	@Override
	@Transactional
    public  List<?> find_By_SQL_Generic(String sql){
	SQLQuery query = getSession().createSQLQuery(sql);
	List lista = query.list();
     return lista;
}
	
	
	/**
	 * METODO USADO PARA REORDENAR LOS VALORES DE LAS TABLAS DE FORMA GENERICA
	 * setea el campo orden con un valor integer where el titulo es un string
	 * 
	 * No te servira para un update where generico pero si para ordenar de forma generica el campo orden pasandole un String de referencia
	 */
	@Override
	@Transactional
	public void updateWhere(Object entity,String SET_CampoNombre,Integer Valor_SET,String WHERE_Campo,Long StringValue) {
		
		Query query = getSession().createQuery(
			    "update "+entity.getClass().getSimpleName()+" set "+SET_CampoNombre+" = :valor1" + " where "+WHERE_Campo+" = :idvalue");
			query.setParameter("idvalue", StringValue);
			query.setParameter("valor1", Valor_SET);
			int result = query.executeUpdate();
		
	}
	/**
	 * Este método consigue traernos un unico valor segun el parámetro que le enviemos
	 * 
	 * Para invocar este método usaremos:
	 *     readByParameterName(new MstCentro(), "id", 1L); 
	 *     readByParameterName(new MstCentro(), "razonSocial", "DVAlpha Solutions TIC S.L");
	 *     
	 * El primer parametro corresponde al nombre del campo de la entidad (no de la tabla)
	 * El segundo parametro corresponde al valor y al tipo de dato que queremos obtener
	 * 
	 *     
	 * @param entity
	 * @param parameter
	 * @param value
	 * @return
	 */
	@Transactional
	public Object readByParameterName(Object entity,String parameter,Object value) {
		Criteria crit = createEntityCriteria(entity.getClass());
		crit.add( Restrictions.like(parameter, value) );
		entity = crit.uniqueResult();
		return entity;
		
	}
	
	
	
	/**
	 * Este método consigue traernos una lista de valores entre dos parametros
	 * 
	 * Para invocar este método usaremos:
	 * 
	 *   (devuelve las ids entre 2 y 4 incluyendolas)
	 *      
	 *      readByParameterBetween(new MstCentro(), "id", 2L, 4L);
	 *      
	 *   (Devuelve los elementos entre dos fechas)
	 *     
	 *      SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 =	i.parse("2017-09-2");
			Date date2 =    i.parse("2017-09-9");
			readByParameterBetween(new MstCentro(), "creacion", date1, date2);
			
	 * El primer parametro es la entidad
	 * El segundo parametro es el campo
	 * El tercer parametro es el valor 1
	 * El cuarto parametro es el valor 2     
	 *      
	 * @param entity
	 * @param parameter
	 * @param valueMin
	 * @param valueMax
	 * @return
	 */
	@Transactional
	public Object readByParameterBetween(Object entity,String parameter,Object valueMin,Object valueMax) {
		Criteria crit = createEntityCriteria(entity.getClass());
		crit.add( Restrictions.between(parameter, valueMin, valueMax) );
		List <?>lista = crit.list();
		return lista;
		
	}
	
	
	
	

}
