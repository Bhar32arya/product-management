package com.bhar32.spring.data.cassandra.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1096736836541376565L;
	@PrimaryKey
	  private UUID id;
	  private String title;
	  private String description;
	  private boolean published;
	  
	  public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	  
	public ProductDTO(UUID id, String title, String description, boolean published) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.published = published;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", title=" + title + ", description=" + description + ", published=" + published
				+ "]";
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	

}
