

package com.cms.model;

public class Vendor {
private int VendorId;
private String VendorName;
private String VendorEmail;
private String VendorPhone;
private String VendorUname;
private String VendorPassword;
private float balance;

public int getVendorId() {
return VendorId;
}

public void setVendorId(int vendorId) {
VendorId = vendorId;
}

public String getVendorName() {
return VendorName;
}

public void setVendorName(String vendorName) {
VendorName = vendorName;
}

public String getVendorEmail() {
return VendorEmail;
}

public void setVendorEmail(String vendorEmail) {
VendorEmail = vendorEmail;
}

public String getVendorPhone() {
return VendorPhone;
}

public void setVendorPhone(String vendorPhone) {
VendorPhone = vendorPhone;
}

public String getVendorUname() {
return VendorUname;
}

public void setVendorUname(String vendorUname) {
VendorUname = vendorUname;
}

public String getVendorPassword() {
return VendorPassword;
}

public void setVendorPassword(String vendorPassword) {
VendorPassword = vendorPassword;
}

public float getBalance() {
return balance;
}

public void setBalance(float balance) {
this.balance = balance;
}

@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((VendorEmail == null) ? 0 : VendorEmail.hashCode());
result = prime * result + VendorId;
result = prime * result + ((VendorName == null) ? 0 : VendorName.hashCode());
result = prime * result + ((VendorPassword == null) ? 0 : VendorPassword.hashCode());
result = prime * result + ((VendorPhone == null) ? 0 : VendorPhone.hashCode());
result = prime * result + ((VendorUname == null) ? 0 : VendorUname.hashCode());
result = prime * result + Float.floatToIntBits(balance);
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
Vendor other = (Vendor) obj;
if (VendorEmail == null) {
if (other.VendorEmail != null)
return false;
} else if (!VendorEmail.equals(other.VendorEmail))
return false;
if (VendorId != other.VendorId)
return false;
if (VendorName == null) {
if (other.VendorName != null)
return false;
} else if (!VendorName.equals(other.VendorName))
return false;
if (VendorPassword == null) {
if (other.VendorPassword != null)
return false;
} else if (!VendorPassword.equals(other.VendorPassword))
return false;
if (VendorPhone == null) {
if (other.VendorPhone != null)
return false;
} else if (!VendorPhone.equals(other.VendorPhone))
return false;
if (VendorUname == null) {
if (other.VendorUname != null)
return false;
} else if (!VendorUname.equals(other.VendorUname))
return false;
if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
return false;
return true;
}

@Override
public String toString() {
return "Vendor [VendorId=" + VendorId + ", VendorName=" + VendorName + ", VendorEmail=" + VendorEmail
+ ", VendorPhone=" + VendorPhone + ", VendorUname=" + VendorUname + ", VendorPassword=" + VendorPassword
+ ", balance=" + balance + "]";
}

public Vendor(int vendorId, String vendorName, String vendorEmail, String vendorPhone, String vendorUname,
String vendorPassword, float balance) {
super();
VendorId = vendorId;
VendorName = vendorName;
VendorEmail = vendorEmail;
VendorPhone = vendorPhone;
VendorUname = vendorUname;
VendorPassword = vendorPassword;
this.balance = balance;
}

public Vendor() {
super();
// TODO Auto-generated constructor stub
}

public Vendor(Vendor v) {
setVendorId(v.VendorId);
setVendorName(v.VendorName);
setVendorEmail(v.VendorEmail);
setVendorPhone(v.VendorPhone);
setVendorUname(v.VendorUname);
setVendorPassword(v.VendorPassword);
setBalance(v.balance);
}

}
