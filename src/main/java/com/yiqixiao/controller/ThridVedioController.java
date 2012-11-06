/**
 * @文件名称：ThridVedioController.java
 * @类路径：com.school.teacher.controller
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20129:13:27 PM
 */
package com.yiqixiao.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yiqixiao.biz.model.Vedio;
import com.yiqixiao.biz.service.VedioService;
import com.yiqixiao.biz.thrid.ThridVedioService;
import com.yiqixiao.biz.thrid.util.VedioUploadConstans;
import com.yiqixiao.utils.UrlPatternConsts;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20129:13:27 PM
 */
@Controller
public class ThridVedioController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ThridVedioController.class);
	
	@Autowired
	private ThridVedioService thridVedioService;
	
	@Autowired
	private VedioService vedioService;
	
	@RequestMapping(value = "/vedio/upload", method = RequestMethod.GET)
	public ModelAndView upload(HttpServletRequest request, ModelAndView mav){
		mav.setViewName("/vedio/upload");
		String result= thridVedioService.uploadVedio("home");
		logger.error("this is a test");
		mav.addObject("uploadResult", result);
		return mav;
	}
	
	@RequestMapping(value = "/vedio/sucess", method = RequestMethod.GET)
	public ModelAndView sucess(HttpServletRequest request, ModelAndView mav){
		
		mav.setViewName("/vedio/sucess");
		try {
		String queryString=request.getQueryString();
		Vedio vedio=buildVeido(queryString);
		vedioService.saveVedio(vedio);
		
		mav.addObject("successVedio", vedio);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return mav;
	}
	
	@RequestMapping( method = RequestMethod.GET,value = UrlPatternConsts.VEDIO_VIEW)
	public ModelAndView view(HttpServletRequest request, ModelAndView mav,@PathVariable Integer vedioId){
		mav.setViewName("/vedio/view");
		Vedio vedio=vedioService.findVedioById(vedioId);
		mav.addObject("vedio",vedio);
		return mav;
	}
	
	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 16, 20126:31:52 PM
	 * @参数：@param queryString
	 * @参数：@return
	 * @return:Vedio
	 */
	private Vedio buildVeido(String queryString) {
		Vedio vedio=new Vedio();
		String[] obejctStr=queryString.split("&");
		Map<String,String> obejctMap=new HashMap<String,String>();
		for(int index=0;index<obejctStr.length;index++){
		String[] restStr=obejctStr[index].split("=");
		obejctMap.put(restStr[0], restStr[1]);
		}
		vedio.setAttach(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_ATTACH));
		vedio.setAuthor(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_SID));
		try {
			vedio.setImage(URLDecoder.decode(URLDecoder.decode(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_COVER),"UTF-8"),"UTF-8"));
			String player=obejctMap.get(VedioUploadConstans.RESULT_VEDIO_PLAYER);
			vedio.setPath(URLDecoder.decode(URLDecoder.decode(player,"UTF-8"),"UTF-8"));
			String realPath=StringUtils.substringAfter(player, "v_");
			realPath="open_"+realPath;
			vedio.setRealPath("http://player.56.com/3000000224/"+realPath);
			vedio.setTitle(URLDecoder.decode(URLDecoder.decode(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_SUBJECT),"UTF-8"),"UTF-8"));
			vedio.setSummary(URLDecoder.decode(URLDecoder.decode(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_MSG),"UTF-8"),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		}
		vedio.setStatus("s");
		vedio.setResult(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_RESULT));
		vedio.setVid(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_VID));
		vedio.setVpublic(obejctMap.get(VedioUploadConstans.RESULT_VEDIO_COOP_PUBLIC));
		return vedio;
	}

	@RequestMapping(value = "/vedio/fail", method = RequestMethod.GET)
	public ModelAndView fail(HttpServletRequest request, ModelAndView mav){
		mav.setViewName("/vedio/fail");
		String  requestParams = request.getQueryString();

		String message=null;
		try {
			message=URLDecoder.decode(URLDecoder.decode(requestParams,"UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		}
	
		Vedio vedio= new Vedio();
		vedio.setStatus("f");
		vedioService.saveVedio(vedio);
		mav.addObject("queryString", StringUtils.substring(message, message.indexOf("msg=")+4, message.indexOf("&amp;subject")-8));
		return mav;
	}

}
