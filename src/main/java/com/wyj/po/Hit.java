package com.wyj.po;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hits database table.
 * 
 */
@Entity
@Table(name="hits")
@NamedQuery(name="Hit.findAll", query="SELECT h FROM Hit h")
public class Hit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ip;

	@Temporal(TemporalType.DATE)
	private Date time;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="AId")
	private Article article;

	public Hit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}