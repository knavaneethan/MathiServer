package com.navproduct.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="session")
public class Session extends BaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7097701164818257831L;
	
	@Column(unique=true)
	String id;
	@Id
	@Column(name="user_id")
	Integer userId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	Date createdTime;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_time")
	Date modifiedTime;
	@Column(name="valid_till", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	Date validTill;

	public String toString() {
		return "Session [id=" + id + ", userId=" + userId + ", createdTime=" + createdTime + ", validTill=" + validTill + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

}
