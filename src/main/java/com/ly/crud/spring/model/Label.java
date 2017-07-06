package com.ly.crud.spring.model;

public class Label {
	
	private Long id;
	
	private String labelCode;
	
	private Long orgID;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}
	

	public Long getOrgID() {
		return orgID;
	}

	public void setOrgID(Long orgID) {
		this.orgID = orgID;
	}

	@Override
	public String toString() {
		return "Label [id=" + id + ", labelCode=" + labelCode + "]";
	}
	
	
}
