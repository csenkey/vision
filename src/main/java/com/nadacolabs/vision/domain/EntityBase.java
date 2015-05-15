package com.nadacolabs.vision.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "created")
    private long creationDate = System.currentTimeMillis();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public long getCreationDate() {
		return creationDate;
	}

}
