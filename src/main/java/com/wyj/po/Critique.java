package com.wyj.po;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the critique database table.
 * 
 */
@Entity
@NamedQuery(name="Critique.findAll", query="SELECT c FROM Critique c")
public class Critique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String content;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="AId")
	private Article article;

	public Critique() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}