package com.cnbr.service.api.resources;

import java.util.List;

public class SpringAppConfiguration {
	private List<String> springFileLocations;
	private List<JdbcDataSourceConfig> jdbcDataSourcesConfigs;
	
	public List<String> getSpringFileLocations() {
		return springFileLocations;
	}
	public void setSpringFileLocations(List<String> springFileLocations) {
		this.springFileLocations = springFileLocations;
	}
	public List<JdbcDataSourceConfig> getJdbcDataSourcesConfigs() {
		return jdbcDataSourcesConfigs;
	}
	public void setJdbcDataSourcesConfigs(List<JdbcDataSourceConfig> jdbcDataSourcesConfigs) {
		this.jdbcDataSourcesConfigs = jdbcDataSourcesConfigs;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jdbcDataSourcesConfigs == null) ? 0 : jdbcDataSourcesConfigs.hashCode());
		result = prime * result + ((springFileLocations == null) ? 0 : springFileLocations.hashCode());
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
		SpringAppConfiguration other = (SpringAppConfiguration) obj;
		if (jdbcDataSourcesConfigs == null) {
			if (other.jdbcDataSourcesConfigs != null)
				return false;
		} else if (!jdbcDataSourcesConfigs.equals(other.jdbcDataSourcesConfigs))
			return false;
		if (springFileLocations == null) {
			if (other.springFileLocations != null)
				return false;
		} else if (!springFileLocations.equals(other.springFileLocations))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SpringAppConfiguration [springFileLocations=" + springFileLocations + ", jdbcDataSourcesConfigs="
				+ jdbcDataSourcesConfigs + "]";
	}
	
}
