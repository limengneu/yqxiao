/**
 * @文件名称：VedioServiceTest.java
 * @类路径：com.school.biz.service
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 201210:56:19 AM
 */
package com.yiqixiao.biz.service;

import java.net.URLDecoder;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 201210:56:19 AM
 */
public class VedioServiceTest {

	@Test
	public void test() {
        String src="http://player.56.com/v_71259119.swf";
		System.out.println(StringUtils.substringAfter(src, "v_"));
	}
	
	
	@Test
	public void testURLdecode() throws Exception {
        String src="Upload, Fail! vid=0&amp;sid=home&amp;msg=%25E8%25AF%25B7%25E4%25B8%258D%25E8%25A6%2581%25E9%2587%258D%25E5%25A4%258D%25E4%25B8%258A%25E4%25BC%25A0%25E7%259B%25B8%25E5%2590%258C%25E8%25A7%2586%25E9%25A2%2591&amp;subject=";
		String str=URLDecoder.decode(URLDecoder.decode(src, "UTF-8"),"UTF-8");
        System.out.println(str);
		System.out.println(str.substring(str.indexOf("msg=")+4,str.indexOf("&amp;subject") ));
	}

	
}
