package com.mall.model;
/**
 * 评论信息实体类
 * @author gupeng
 *
 */

import java.util.Date;

public class CommentResponse {
	// 评论ID
	private String comment_id;
	// 评论标题
	private String comment_title;
	// 评论内容
	private String comment_content;
	// 评论时间 默认值当前时间
	private Date comment_time;
	// 评论ID
	private String author_id;
	// 商品信息ID
	private String product_id;
	// 回复评论ID
	private String response_id;

	/**
	 * 默认无参构造方法
	 */
	public CommentResponse() {
	}

	/**
	 * 带参构造方法
	 * 
	 * @param comment_id 评论ID
	 * @param comment_title 评论标题
	 * @param comment_content 评论内容
	 * @param author_id 评论ID
	 * @param product_id 商品信息ID
	 * @param response_id 回复评论ID
	 */
	public CommentResponse(String comment_id, String comment_title, String comment_content, String author_id,
			String product_id, String response_id) {
		this.comment_id = comment_id;
		this.comment_title = comment_title;
		this.comment_content = comment_content;
		this.author_id = author_id;
		this.product_id = product_id;
		this.response_id = response_id;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_title() {
		return comment_title;
	}

	public void setComment_title(String comment_title) {
		this.comment_title = comment_title;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getResponse_id() {
		return response_id;
	}

	public void setResponse_id(String response_id) {
		this.response_id = response_id;
	}

}
