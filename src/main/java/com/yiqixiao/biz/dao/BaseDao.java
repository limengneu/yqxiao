/**
 * @文件名称：BaseDao.java
 * @类路径：com.school.biz.dao
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 20122:52:41 PM
 */
package com.yiqixiao.biz.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yiqixiao.biz.model.BaseModel;



/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 20122:52:41 PM
 */
@Repository
public abstract class BaseDao<T extends BaseModel> {
	
	@PersistenceContext
	protected EntityManager em;

	protected Class<T> entityClass = null;
	
	@SuppressWarnings("unchecked")
	public BaseDao() {

		try {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (Exception e) {

			/**
			 * this exception is only raised in spring proxy bean, so we just
			 * ignore it
			 */
		}

	}
	
	public T find(Integer id) {
		return em.find(entityClass, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public T findByValue(String column, String value) {
		Query query = em.createQuery("SELECT o FROM "
				+ entityClass.getSimpleName() + " o WHERE o." + column + " =:"
				+ column);
		query.setParameter(column, value);

		return (T) query.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> findListByValue(String column,  String value) {
		Query query = em.createQuery("SELECT o FROM "
				+ entityClass.getSimpleName() + " o WHERE o." + column + " =:"
				+ column);
		query.setParameter(column, value);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findListByPage(String column,  String value,Integer page,Integer pageSize) {
		
		Query query = em.createQuery("SELECT o FROM "
				+ entityClass.getSimpleName() + " o WHERE o." + column + " =:"
				+ column +"  order by o.modifyAt desc");
		query.setParameter(column, value);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	public Long countByPage(String column,  String value) {
		Query query = em.createQuery("SELECT count(o.id) FROM "
				+ entityClass.getSimpleName() + " o WHERE o." + column + " =:"
				+ column);
		query.setParameter(column, value);
		return (Long) query.getSingleResult();
	}
	
	
	@Transactional
	public T save(T baseModel) {
		if (baseModel.getId() == null) {
			baseModel.prePersist();
			em.persist(baseModel);
			return baseModel;
		} else {
			baseModel.preUpdate();
			return em.merge(baseModel);
		}
	}

	@Transactional
	public void delete(Long id) {

		deleteByValue("id", id);
	}

	@Transactional
	public void deleteByValue(String column, Object value) {

		Query query = em.createQuery("DELETE FROM "
				+ entityClass.getSimpleName() + " e WHERE e." + column + " =:"
				+ column);
		query.setParameter(column, value);
		query.executeUpdate();
	}

	@Transactional
	public void deleteByValues(String column, List<?> values) {

		Query query = em.createQuery("DELETE FROM "
				+ entityClass.getSimpleName() + " e WHERE e." + column
				+ " in (:" + column + ")");
		query.setParameter(column, values);
		query.executeUpdate();
	}
	

}
