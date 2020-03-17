package com.cnbr.service.api.resources;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDataSourceConfig {
	private String dataSourceName;
	private BasicDataSource basicDataSource;
	
	public String getDataSourceName() {
		return dataSourceName;
	}
	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}
	public BasicDataSource getBasicDataSource() {
		return basicDataSource;
	}
	public void setBasicDataSource(BasicDataSource basicDataSource) {
		this.basicDataSource = basicDataSource;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basicDataSource == null) ? 0 : basicDataSource.hashCode());
		result = prime * result + ((dataSourceName == null) ? 0 : dataSourceName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JdbcDataSourceConfig other = (JdbcDataSourceConfig) obj;
		if (basicDataSource == null) {
			if (other.basicDataSource != null)
				return false;
		} else if (!basicDataSource.equals(other.basicDataSource))
			return false;
		if (dataSourceName == null) {
			if (other.dataSourceName != null)
				return false;
		} else if (!dataSourceName.equals(other.dataSourceName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JdbcDataSourceConfig [dataSourceName=" + dataSourceName + ", basicDataSource=" + basicDataSource + "]";
	}
	
	
	
}
