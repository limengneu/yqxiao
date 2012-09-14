/**
 * @文件名称：Navigator.java
 * @类路径：com.school.biz.paginator
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 20123:50:43 PM
 */
package com.yiqixiao.common.paginator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yiqixiao.common.url.UrlFormatter;


/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 20123:50:43 PM
 */
public class Paginator extends BaseNavigator {

	private static final String PAGE_NUMBER_DISPLAY_PATTERN = "{0}";
	public final static int FIRST_PAGE = 1;
	private final static int DEFAULT_MAX_LINK_COUNT = 4;

	private int page;
	private int pageSize;
	private int itemCount;

	private int maxLinkCount;
	private int leftLinkIndex;
	// exclusive
	private int rightLinkIndex;
	private String linkPattern;
	
	public Paginator(String linkPattern, Integer page, int pageSize,Integer itemCount) {

		this(linkPattern, page, pageSize,itemCount, DEFAULT_MAX_LINK_COUNT,null);
	}
	
	public Paginator(String linkPattern, Integer page, int pageSize,Integer itemCount,
			int maxLinkCount) {

		this(linkPattern, page, pageSize,itemCount, maxLinkCount, null);
	}


	public Paginator(String linkPattern, Integer page, int pageSize ,Integer itemCount,
			int maxLinkCount,Map<String, Object> optionalArgumentMap) {

		super(optionalArgumentMap);

		this.linkPattern = linkPattern;

		if (page == null) {

			this.page = FIRST_PAGE;
		} else {

			this.page = page;
		}

		this.pageSize = pageSize;
		this.maxLinkCount = maxLinkCount;
        this.itemCount=itemCount;

	}

	public Paginator(String linkPattern, Integer page, int pageSize,Integer itemCount,
			Map<String, Object> optionalArgumentMap) {

		this(linkPattern, page, pageSize,itemCount, DEFAULT_MAX_LINK_COUNT,
				optionalArgumentMap);
	}
	/* (non-Javadoc)
	 * @see com.school.biz.paginator.BaseNavigator#getLinkList()
	 */
	@Override
	public List<Link> getLinkList() {
		List<Link> linkList = new ArrayList<Link>();

		int pageCount = getPageCount();

		calculateLinkIndexRange(pageCount);

		for (int i = leftLinkIndex; i < rightLinkIndex; i++) {

			String linkName = MessageFormat.format(PAGE_NUMBER_DISPLAY_PATTERN,
					new Object[] { i });

			String linkHref = UrlFormatter.format(linkPattern,
					buildArgumentMap(i));

			boolean isCurrentPage = (i == page);
			Link link = new Link(linkName, linkHref, isCurrentPage);

			linkList.add(link);
		}

		return linkList;
	
	}
	public Link getFirstPageLink() {

		List<Link> linkList = getLinkList();

		if (linkList.isEmpty()) {
			return null;
		}

		if (linkList.get(0).getName().equals(Integer.toString(FIRST_PAGE))) {
			return null;
		}

		String linkHref = UrlFormatter.format(linkPattern,
				buildArgumentMap(FIRST_PAGE));

		Link link = new Link(Integer.toString(FIRST_PAGE), linkHref, false);
		return link;
	}
	
	public Link getLastPageLink() {

		List<Link> linkList = getLinkList();

		if (linkList.isEmpty()) {
			return null;
		}

		int pageCount = getPageCount();
		if (linkList.get(linkList.size() - 1).getName()
				.equals(Integer.toString(pageCount))) {
			return null;
		}

		String linkHref = UrlFormatter.format(linkPattern,
				buildArgumentMap(pageCount));

		Link link = new Link(Integer.toString(pageCount), linkHref, false);
		return link;
	}

	public boolean hasPreviousLink() {

		boolean isFirstPage = (page == FIRST_PAGE);

		return !isFirstPage;
	}

	public Link getPreviousLink() {

		String linkHref = UrlFormatter.format(linkPattern,
				buildArgumentMap(page - 1));
		Link link = new Link("上一页", linkHref, false);
		return link;
	}

	public boolean hasNextLink() {

		boolean isLastPage = (page == getPageCount());

		return !isLastPage;
	}

	public Link getNextLink() {

		String linkHref = UrlFormatter.format(linkPattern,
				buildArgumentMap(page + 1));
		Link link = new Link("下一页", linkHref, false);
		return link;
	}
	
	public boolean hasHeadOmission() {

		return leftLinkIndex > FIRST_PAGE + 1;
	}

	public boolean hasTailOmission() {

		return rightLinkIndex < getPageCount();
	}

	
	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 17, 20124:12:26 PM
	 * @参数：@param i
	 * @参数：@return
	 * @return:Object
	 */
	private Map<String, Object>  buildArgumentMap(int i) {
		Map<String, Object> argumentMap = new HashMap<String, Object>(
				optionalArgumentMap);
		argumentMap.put("page", page);
		return argumentMap;
	}

	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 17, 20124:11:21 PM
	 * @参数：@param pageCount
	 * @return:void
	 */
	private void calculateLinkIndexRange(int pageCount) {
		int linkCount = Math.min(pageCount, maxLinkCount);

		int leftLinkCount = (linkCount - 1) / 2;
		int rightLinkCount = linkCount - leftLinkCount - 1;

		int minLeftIndex = 1;
		int maxRightIndex = pageCount + 1;

		leftLinkIndex = page - leftLinkCount;
		rightLinkIndex = page + rightLinkCount + 1;

		if (leftLinkIndex < minLeftIndex) {

			leftLinkIndex = minLeftIndex;
			rightLinkIndex = minLeftIndex + linkCount;

		} else if (rightLinkIndex > maxRightIndex) {

			rightLinkIndex = maxRightIndex;
			leftLinkIndex = rightLinkIndex - linkCount;
		}
		
	}

	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 17, 20124:11:16 PM
	 * @参数：@return
	 * @return:int
	 */
	private int getPageCount() {
		int pageCount = itemCount / pageSize;

		pageCount = itemCount % pageSize == 0 ? pageCount : pageCount + 1;

		return pageCount;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @return the maxLinkCount
	 */
	public int getMaxLinkCount() {
		return maxLinkCount;
	}

	/**
	 * @param maxLinkCount the maxLinkCount to set
	 */
	public void setMaxLinkCount(int maxLinkCount) {
		this.maxLinkCount = maxLinkCount;
	}

	/**
	 * @return the leftLinkIndex
	 */
	public int getLeftLinkIndex() {
		return leftLinkIndex;
	}

	/**
	 * @param leftLinkIndex the leftLinkIndex to set
	 */
	public void setLeftLinkIndex(int leftLinkIndex) {
		this.leftLinkIndex = leftLinkIndex;
	}

	/**
	 * @return the rightLinkIndex
	 */
	public int getRightLinkIndex() {
		return rightLinkIndex;
	}

	/**
	 * @param rightLinkIndex the rightLinkIndex to set
	 */
	public void setRightLinkIndex(int rightLinkIndex) {
		this.rightLinkIndex = rightLinkIndex;
	}

	/**
	 * @return the linkPattern
	 */
	public String getLinkPattern() {
		return linkPattern;
	}
	/**
	 * @param linkPattern the linkPattern to set
	 */
	public void setLinkPattern(String linkPattern) {
		this.linkPattern = linkPattern;
	}
}
