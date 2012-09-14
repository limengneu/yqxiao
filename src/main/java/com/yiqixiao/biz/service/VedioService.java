/**
 * @文件名称：VedioService.java
 * @类路径：com.school.biz.service
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 20124:07:17 PM
 */
package com.yiqixiao.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yiqixiao.biz.dao.VedioDao;
import com.yiqixiao.biz.model.Vedio;
import com.yiqixiao.biz.query.VedioQuery;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 20124:07:17 PM
 */
@Component
public class VedioService {

	
	@Autowired
	private VedioDao vedioDao;
	
	public Vedio saveVedio(Vedio vedio){
		return vedioDao.save(vedio);
	}
	
	public Vedio updateVedio(Vedio vedio){
		return vedioDao.save(vedio);
	}
	
	public Vedio findVedio(String column,String value){
		return  vedioDao.findByValue(column, value);
	}
	
	
	public Vedio findVedioById(Integer vedioId){
		return  vedioDao.find(vedioId);
	}
	
	public List<Vedio> findVedios(String column,String value){
		return  vedioDao.findListByValue(column, value);
	}
	
	public VedioQuery findListByPage(String column,String value,Integer page,Integer pageSize){
		
		List<Vedio>  vedios=vedioDao.findListByPage(column, value,page,pageSize);
		Long size=vedioDao.countByPage(column, value);
		VedioQuery vedioQuery=new VedioQuery(vedios,size.intValue());
		 return vedioQuery;
	}
	

}
