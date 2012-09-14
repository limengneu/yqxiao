/**
 * @文件名称：BaseNavigator.java
 * @类路径：com.school.biz.paginator
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 20123:47:57 PM
 */
package com.yiqixiao.common.paginator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 20123:47:57 PM
 */
public abstract class BaseNavigator {
	protected Map<String, Object> optionalArgumentMap;

	public BaseNavigator(Map<String, Object> optionalArgumentMap) {

		this.optionalArgumentMap = optionalArgumentMap == null ? new HashMap<String, Object>()
				: optionalArgumentMap;

	}

	public abstract List<Link> getLinkList();

}
