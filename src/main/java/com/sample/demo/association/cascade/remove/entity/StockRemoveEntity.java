package com.sample.demo.association.cascade.remove.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "stock"/*, uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") }*/)
public class StockRemoveEntity implements java.io.Serializable {

	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<StockDailyRecordRemove> stockDailyRecordRemove = new HashSet<StockDailyRecordRemove>(
			0);

	public StockRemoveEntity() {
	}

	public StockRemoveEntity(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public StockRemoveEntity(String stockCode, String stockName,
			Set<StockDailyRecordRemove> stockDailyRecords) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecordRemove = stockDailyRecords;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@OneToMany(orphanRemoval = true, mappedBy = "stockPersist",cascade=CascadeType.ALL)
	public Set<StockDailyRecordRemove> getStockDailyRecordsRemove() {
		return this.stockDailyRecordRemove;
	}

	public void setStockDailyRecordsRemove(Set<StockDailyRecordRemove> stockDailyRecords) {
		this.stockDailyRecordRemove = stockDailyRecords;
	}

}
