package com.yogesh.assetmanagement.modelclass;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Asset")
public class Asset {                

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetId;
	
	@NotBlank
	@Pattern(regexp ="^[A-Za-z0-9 ]+$" , message = "Enter valid asset name [enter ALFA-NUMERIC VALUE]")
	private String assetName;
	
	@NotBlank
	@Pattern(regexp ="^[A-Za-z0-9-]+$" , message = "Enter valid asset type [enter ALFA-NUMERIC VALUE ")
	private String assetType;
	
	@NotBlank
	@Pattern(regexp ="^[A-Za-z0-9-]+$" , message = "Enter valid Serial Number [enter ALFA-NUMERIC VALUE]")
	private String assetSerialNo;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date assetPurchaseDate;
	
	
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetSerialNo() {
		return assetSerialNo;
	}
	public void setAssetSerialNo(String assetSerialNo) {
		this.assetSerialNo = assetSerialNo;
	}
	public Date getAssetPurchaseDate() {
		return assetPurchaseDate;
	}
	public void setAssetPurchaseDate(Date assetPurchaseDate) {
		this.assetPurchaseDate = assetPurchaseDate;
	}
	
	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetName=" + assetName + ", assetType=" + assetType
				+ ", assetSerialNo=" + assetSerialNo + ", assetPurchaseDate=" + assetPurchaseDate + "]";
	}
	
}
