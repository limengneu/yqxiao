package com.yiqixiao.common.web.velocity;

import java.util.Map;
import java.util.Properties;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class VelocityEmailUtil {

	private static VelocityEngine velocity;

	static {
		velocity = new VelocityEngine();
		Properties emailProperties = new Properties();
		emailProperties.setProperty("default.contentType",
				"text/html; charset=utf-8");
		emailProperties.setProperty("output.encoding", "utf-8");
		emailProperties.setProperty("output.encoding", "utf-8");

	 //这里加载类路径里的模板而不是文件系统路径里的模板
    		emailProperties
    				.setProperty("file.resource.loader.class",
    						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	// 也可以用下面方法指定一个绝对路径，不过这样要求你所有的模板都放在该路径下，是有局限的
//		emailProperties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,
//				"classpath:mail");
		emailProperties
				.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");

		velocity.init(emailProperties);
	}

	public static String mergeEmailTemplate(String template,
			Map<String, Object> model) {
		return VelocityEngineUtils.mergeTemplateIntoString(velocity, template,
				"utf-8", model);
	}

}
