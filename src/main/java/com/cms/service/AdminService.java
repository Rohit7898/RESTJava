package com.cms.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cms.connection.DbConnection;
import com.cms.model.Menu_Item;
import com.cms.model.Vendor;

public class AdminService {
public DbConnection db = new DbConnection();
public ArrayList<Vendor> av = new ArrayList<Vendor>();
public boolean addVendor(String Name, String Email, String Phone,String Uname, String Password, float Balance)
{

String[] field= {"Name","Email", "Phone", "Uname", "Password","Balance"};
String[] values= {Name, Email, Phone, Uname, Password, Float.toString(Balance)};
boolean ins=db.insert("Vendor", field, values);
return ins;
}
public boolean deleteVendor(int vid) {

String field= "Vendor_id";
String values= Integer.toString(vid);
if(db.delete("Vendor", field, values))
{
return true;
}
else
{
return false;
}

}
public ArrayList<Vendor> showVendor() {
HashMap<String, String> conditions=new HashMap<String, String>();  
String[] fields= {"*"};

ResultSet resultSet = db.select("Vendor",fields,conditions);
try {
while(resultSet.next()) {
av.add(new Vendor(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getFloat(7)));
       
}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return av;
}

public boolean editVendor(int Id, String Name, String Email, String Phone,String Uname, String Password, float Balance)
{
HashMap<String, String> conditions=new HashMap<String, String>();  
HashMap<String, String> data=new HashMap<String, String>();  
data.put("Vendor_id", Integer.toString(Id));
data.put("Name", Name);
data.put("Email", Email);
data.put("Phone", Phone);
data.put("Uname", Uname);
data.put("Password", Password);
data.put("Balance", Float.toString(Balance));

conditions.put("Vendor_id",Integer.toString(Id));
boolean update=db.update("Vendor", data, conditions);
if(update)
{
return true;
}
else
{
return false;
}
}
}


