package me.mazid.model;

import java.sql.Date;

public class Task {

	private int id;
    private String name;
    private String description;
    private Date dateCreated;
    private Date dateUpdated;
 
        
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name
                + ", description=" + description + ", dateCreated=" + dateCreated
                + ", dateUpdated=" + dateUpdated + "]";
    }

}
