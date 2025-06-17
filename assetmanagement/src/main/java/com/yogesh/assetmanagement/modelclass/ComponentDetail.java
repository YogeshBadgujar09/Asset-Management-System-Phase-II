package com.yogesh.assetmanagement.modelclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="ComponentDetail")
public class ComponentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long componenetId;
	
	@Pattern(regexp = "^[A-Za-Z0-9]$" , message = "Please enter valid OS name ... !!! [NOT USE SPECIAL SYMBOLS]")
	private String operatingSystsem;
	
	@Pattern(regexp = "^[A-Za-Z0-9]$" , message = "Please enter valid Processor ... !!! [NOT USE SPECIAL SYMBOLS]")
	private String processor ;
	
	@Pattern(regexp = "^[A-Za-Z0-9]$" , message = "Please enter valid RAM  ... !!! [NOT USE SPECIAL SYMBOLS]")
	private String ram;
	
	@Pattern(regexp = "^[A-Za-Z0-9]$" , message = "Please enter valid Storage ... !!! [NOT USE SPECIAL SYMBOLS]")
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
