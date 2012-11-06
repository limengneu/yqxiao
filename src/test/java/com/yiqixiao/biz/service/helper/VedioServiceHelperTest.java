/**
 * @文件名称：VedioServiceHelperTest.java
 * @类路径：com.yiqixiao.biz.service.helper
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 20128:03:19 PM
 */
package com.yiqixiao.biz.service.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 20128:03:19 PM
 */
@ContextConfiguration("/common-service.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VedioServiceHelperTest {

	@Autowired
	private VedioServiceHelper vedioServiceHelper;
	@Test
	public void testBuildLastesetVedio() {
		try {
			vedioServiceHelper.buildLastesetVedio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
