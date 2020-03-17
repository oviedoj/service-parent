package com.cnbr.service.domain.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public abstract class BaseDomain implements Serializable {
	/**
	 * 
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	protected Integer id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM'T'HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	protected LocalDateTime insertTs;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)	
	protected String insertedBy;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM'T'HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	protected LocalDateTime updateTs;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	protected String updateBy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getInsertTs() {
		return insertTs;
	}
	public void setInsertTs(LocalDateTime insertTs) {
		this.insertTs = insertTs;
	}
	public String getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	public LocalDateTime getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(LocalDateTime updateTs) {
		this.updateTs = updateTs;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Override
	public String toString() {
		return "BaseDomain [id=" + id + ", insertTs=" + insertTs + ", insertedBy=" + insertedBy + ", updateTs="
				+ updateTs + ", updateBy=" + updateBy + "]";
	}
}
