/**
 * @文件名称：VedioGetServiceTest.java
 * @类路径：com.yiqixiao.biz.thrid
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 201210:38:58 AM
 */
package com.yiqixiao.biz.thrid;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yiqixiao.biz.thrid.model.ChannelVedio;
import com.yiqixiao.biz.thrid.model.VedioInfo;
import com.yiqixiao.biz.thrid.model.VedioPastor;
import com.yiqixiao.biz.thrid.util.JsonUtils;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 201210:38:58 AM
 */
@ContextConfiguration("/common-service.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VedioGetServiceTest {
	@Autowired
	private VedioGetService vedioGetService;

	@Test
	public void testGetThirdVedio() throws Exception {
	String	resul5=vedioGetService.getThirdVedioFromChannel("129", 10, 1);
	System.out.print(resul5);

	}
	
	
	@Test
	public void testGetThirdVedioFromVId() throws Exception {
		List<VedioInfo> vedios=vedioGetService.getThirdVedioFromVId("65919627,57101472,69404471");
	

	for(VedioInfo vedioInfo:vedios){
		System.out.println(vedioInfo.getImg());
    	}
	}
	
	
}
