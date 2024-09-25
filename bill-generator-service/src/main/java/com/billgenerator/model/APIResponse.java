package com.billgenerator.model;

import java.util.List;
import java.util.Map;

public class APIResponse {
	
	String result;
	String provider;
	String Ducumentation;
	String termOfUse;
	long time_last_update_unix;
	String time_last_update_utc;
	long time_next_update_unix;
	String time_next_update_utc;
	long time_eol_unix;
	String baseCode;
	Map<String,Double> rates;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getDucumentation() {
		return Ducumentation;
	}
	public void setDucumentation(String ducumentation) {
		Ducumentation = ducumentation;
	}
	public String getTermOfUse() {
		return termOfUse;
	}
	public void setTermOfUse(String termOfUse) {
		this.termOfUse = termOfUse;
	}
	public long getTime_last_update_unix() {
		return time_last_update_unix;
	}
	public void setTime_last_update_unix(long time_last_update_unix) {
		this.time_last_update_unix = time_last_update_unix;
	}
	public String getTime_last_update_utc() {
		return time_last_update_utc;
	}
	public void setTime_last_update_utc(String time_last_update_utc) {
		this.time_last_update_utc = time_last_update_utc;
	}
	public long getTime_next_update_unix() {
		return time_next_update_unix;
	}
	public void setTime_next_update_unix(long time_next_update_unix) {
		this.time_next_update_unix = time_next_update_unix;
	}
	public String getTime_next_update_utc() {
		return time_next_update_utc;
	}
	public void setTime_next_update_utc(String time_next_update_utc) {
		this.time_next_update_utc = time_next_update_utc;
	}
	public long getTime_eol_unix() {
		return time_eol_unix;
	}
	public void setTime_eol_unix(long time_eol_unix) {
		this.time_eol_unix = time_eol_unix;
	}
	public String getBaseCode() {
		return baseCode;
	}
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	
	
	

}
