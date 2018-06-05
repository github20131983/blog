package com.wyj.po;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int hasread;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	//bi-directional many-to-one association to Critique
	@OneToMany(mappedBy="article")
	private List<Critique> critiques;

	//bi-directional many-to-one association to Hit
	@OneToMany(mappedBy="article")
	private List<Hit> hits;

	public Article() {
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHasread() {
		return this.hasread;
	}

	public void setHasread(int hasread) {
		this.hasread = hasread;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Critique> getCritiques() {
		return this.critiques;
	}

	public void setCritiques(List<Critique> critiques) {
		this.critiques = critiques;
	}

	public Critique addCritique(Critique critique) {
		getCritiques().add(critique);
		critique.setArticle(this);

		return critique;
	}

	public Critique removeCritique(Critique critique) {
		getCritiques().remove(critique);
		critique.setArticle(null);

		return critique;
	}

	public List<Hit> getHits() {
		return this.hits;
	}

	public void setHits(List<Hit> hits) {
		this.hits = hits;
	}

	public Hit addHit(Hit hit) {
		getHits().add(hit);
		hit.setArticle(this);

		return hit;
	}

	public Hit removeHit(Hit hit) {
		getHits().remove(hit);
		hit.setArticle(null);

		return hit;
	}

}