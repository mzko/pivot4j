package com.eyeq.pivot4j.analytics.datasource;

import java.io.Serializable;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.eyeq.pivot4j.state.Configurable;

public class ConnectionMetadata implements Configurable, Serializable {

	private static final long serialVersionUID = 1613489385973603487L;

	private String dataSourceName;

	private String cubeName;

	private String catalogName;

	public ConnectionMetadata() {
	}

	/**
	 * @param dataSourceName
	 * @param catalogName
	 * @param cubeName
	 */
	public ConnectionMetadata(String dataSourceName, String catalogName,
			String cubeName) {
		this.dataSourceName = dataSourceName;
		this.catalogName = catalogName;
		this.cubeName = cubeName;
	}

	/**
	 * @return the dataSourceName
	 */
	public String getDataSourceName() {
		return dataSourceName;
	}

	/**
	 * @param dataSourceName
	 *            the dataSourceName to set
	 */
	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	/**
	 * @return the cubeName
	 */
	public String getCubeName() {
		return cubeName;
	}

	/**
	 * @param cubeName
	 *            the cubeName to set
	 */
	public void setCubeName(String cubeName) {
		this.cubeName = cubeName;
	}

	/**
	 * @return the catalogName
	 */
	public String getCatalogName() {
		return catalogName;
	}

	/**
	 * @param catalogName
	 *            the catalogName to set
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	/**
	 * @see com.eyeq.pivot4j.state.Configurable#saveSettings(org.apache.commons.configuration.HierarchicalConfiguration)
	 */
	@Override
	public void saveSettings(HierarchicalConfiguration configuration) {
		if (configuration == null) {
			throw new IllegalArgumentException(
					"Configuration object cannot be null.");
		}

		configuration.addProperty("dataSource", dataSourceName);
		configuration.addProperty("catalog", catalogName);
		configuration.addProperty("cube", cubeName);
	}

	/**
	 * @see com.eyeq.pivot4j.state.Configurable#restoreSettings(org.apache.commons.configuration.HierarchicalConfiguration)
	 */
	@Override
	public void restoreSettings(HierarchicalConfiguration configuration) {
		if (configuration == null) {
			throw new IllegalArgumentException(
					"Configuration object cannot be null.");
		}

		this.dataSourceName = configuration.getString("dataSource");
		this.catalogName = configuration.getString("catalog");
		this.cubeName = configuration.getString("cube");
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("dataSourceName", dataSourceName)
				.append("cubeName", cubeName)
				.append("catalogName", catalogName).toString();
	}
}