package com.dvalpha.core.dao;

import java.io.Serializable;


import java.lang.reflect.ParameterizedType;

import javax.persistence.criteria.CriteriaUpdate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //al ser un DAO se ha de marcar con el estereotipo Repository

public abstract class AbstractDao<PK extends Serializable, T> {
	private static final Logger logger = Logger.getLogger(AbstractDao.class);	
	private  Class<T> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	/**
	 * Metodo que provee al DAO de la conexion (session) con hibernate
	 * @return
	 */
	protected Session getSession(){
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		return session;
		
		
	}
	
    
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	
	
	/**
	 * Gracias a este metodo podemos hacer generico nuestro DAO ya que persistimos las entidades
	 * seteando la "persistence class" en el momento de su uso de forma dinamica
	 * @param id
	 * @param clase
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object abstractDaoGetByKey(long id,Class clase) {
		setPersistentClass(clase);
		Session ses =getSession();
		Object object = ses.get(persistentClass, id);
		return object;
	}

	/**
	 * Las transacciones deben ser usadas por Spring para ello ponemos la
	 * anotacion @Transaccional en cada uno de los metodos
	 * @param entity
	 */
	@Transactional
	public void abstractDaoPersist(Object entity) {
		
		Session ses =getSession();
		
		ses.persist(entity);
		
		
	}
	@Transactional
    public void abstractDaoInsertEntity(Object entity) {
		Session ses =getSession();
		ses.persist(entity);
	}

	@Transactional
	public void abstractDaoUpdate(Object entity) {
		Session ses =getSession();
		ses.merge(entity);
	}

	
	@Transactional
	public void  abstractDaoDelete(Object entity) {
		Session ses =getSession();
		ses.delete(entity);
		ses.flush();
	    }
	
	@Transactional
	protected Criteria createEntityCriteria(Class clase){
		setPersistentClass(clase);
		Criteria crit =getSession().createCriteria(persistentClass);
		return crit;
	}

	
	
}
