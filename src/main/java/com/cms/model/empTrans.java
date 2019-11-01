package com.cms.model;

import java.sql.Date;
import java.sql.Time;

public class empTrans {
	private int OrderId;
	private int ItemId;
	private String ItemName;
	private Date date;
	private float TotalPrice;
	private String VendorName;
    private int Status;
	public empTrans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public empTrans(int orderId, int itemId, String itemName, Date date, float totalPrice, String vendorName,
			int status) {
		super();
		OrderId = orderId;
		ItemId = itemId;
		ItemName = itemName;
		this.date = date;
		TotalPrice = totalPrice;
		VendorName = vendorName;
		Status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ItemId;
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		result = prime * result + OrderId;
		result = prime * result + Status;
		result = prime * result + Float.floatToIntBits(TotalPrice);
		result = prime * result + ((VendorName == null) ? 0 : VendorName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		empTrans other = (empTrans) obj;
		if (ItemId != other.ItemId)
			return false;
		if (ItemName == null) {
			if (other.ItemName != null)
				return false;
		} else if (!ItemName.equals(other.ItemName))
			return false;
		if (OrderId != other.OrderId)
			return false;
		if (Status != other.Status)
			return false;
		if (Float.floatToIntBits(TotalPrice) != Float.floatToIntBits(other.TotalPrice))
			return false;
		if (VendorName == null) {
			if (other.VendorName != null)
				return false;
		} else if (!VendorName.equals(other.VendorName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "empTrans [OrderId=" + OrderId + ", ItemId=" + ItemId + ", ItemName=" + ItemName + ", date=" + date
				+ ", TotalPrice=" + TotalPrice + ", VendorName=" + VendorName + ", Status=" + Status + "]";
	}
	
	
}
