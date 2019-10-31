package com.cms.model;

import java.sql.Date;
import java.sql.Time;

public class Cart {
	private int OrderId;
	private int ItemID;
	private String ItemName;
	private int Quantity;
	private Date date;
	private	String  VendorName;
	private float TotalPrice;
    private int Status;
    
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public float getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public Cart(int orderId, int itemId, String itemName, int quantity, Date date,float totalPrice, String vendorName, 
			int status) {
		super();
		OrderId = orderId;
		ItemID=itemId;
		ItemName = itemName;
		Quantity = quantity;
		this.date = date;
		VendorName = vendorName;
		TotalPrice = totalPrice;
		Status = status;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		result = prime * result + OrderId;
		result = prime * result + Quantity;
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
		Cart other = (Cart) obj;
		if (ItemName == null) {
			if (other.ItemName != null)
				return false;
		} else if (!ItemName.equals(other.ItemName))
			return false;
		if (OrderId != other.OrderId)
			return false;
		if (Quantity != other.Quantity)
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
		return "Cart [OrderId=" + OrderId + ", ItemName=" + ItemName + ", Quantity=" + Quantity + ", date=" + date
				+ ", VendorName=" + VendorName + ", TotalPrice=" + TotalPrice + ", Status=" + Status + "]";
	}
}
