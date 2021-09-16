package com.shwl.navigation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projectfilelink {
	@Id
	@GeneratedValue
	private int id;
	private String link;
	private String pname;
	public Projectfilelink() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Projectfilelink(int id, String link, String pname) {
		super();
		this.id = id;
		this.link = link;
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Projectfilelink [id=" + id + ", link=" + link + ", pname=" + pname + "]";
	}
	
	
}
