package com.wyj.po;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bloginfo database table.
 * 
 */
@Entity
@NamedQuery(name="Bloginfo.findAll", query="SELECT b FROM Bloginfo b")
public class Bloginfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String eblogtitle;

	private String idiograph;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="username")
	private User user;

	public Bloginfo() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEblogtitle() {
		return this.eblogtitle;
	}

	public void setEblogtitle(String eblogtitle) {
		this.eblogtitle = eblogtitle;
	}

	public String getIdiograph() {
		return this.idiograph;
	}

	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}