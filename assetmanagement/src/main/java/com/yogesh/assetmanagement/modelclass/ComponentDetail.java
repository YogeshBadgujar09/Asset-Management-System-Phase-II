package com.yogesh.assetmanagement.modelclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CompenentDetail")
public class ComponentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long componenetId;
	private String operatingSystsem;
	private String processor ;
	private String ram;
	private String storage ;
	
	
	public void setComponenetId(Long componenetId) {
		this.componenetId = componenetId;
	}
	public void setOperatingSystsem(String operatingSystsem) {
		this.operatingSystsem = operatingSystsem;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	
	public Long getComponenetId() {
		return componenetId;
	}
	public String getOperatingSystsem() {
		return operatingSystsem;
	}
	public String getProcessor() {
		return processor;
	}
	public String getRam() {
		return ram;
	}
	public String getStorage() {
		return storage;
	}
	
	@Override
	public String toString() {
		return "ComponentDetail [componenetId=" + componenetId + ", operatingSystsem=" + operatingSystsem
				+ ", processor=" + processor + ", ram=" + ram + ", storage=" + storage + "]";
	}
	
}
