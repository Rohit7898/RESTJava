package com.cms.service;

import java.awt.Menu;
import java.awt.MenuItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.cms.connection.DbConnection;
import com.cms.model.Cart;
import com.cms.model.DBStatus;
import com.cms.model.Employee;
import com.cms.model.Menu_Item;
import com.cms.model.Order;
import com.cms.model.empTrans;

public class EmployeeService {

	public DbConnection db = new DbConnection();

	public List<Employee> Login( String m_username,String  m_password) 
	{
        // boolean loginYes=true;

	 DbConnection db = new DbConnection();
	 List<Employee> data = new ArrayList<Employee>();
	 ResultSet result=db.loginEmp(m_username, m_password);
	 try {
			while(result.next()) {
				Employee ds= new Employee
						(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),
								result.getString(6),result.getString(7),result.getFloat(8),true);
				data.add(ds);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     return data;
     
	}

	public boolean loginVen(int name, String pass) {
//		 Vendor v= new Vendor();
//		 DbConnection db = new DbConnection();
//		 String selection = "";
//		 String[] fields= {"item_name","item_price"};
//		 HashMap<String, String> conditions=new HashMap<String, String>();   
//	     db.loginVen(name);
//         if(e.getEmployeeId()==name)  
//         {
//        	 if(e.getEmployeePassword().equals(pass))
//        	 {
//        		 if(e.getRole().equals(role))
//        		 {
//        			 return true;
//        		 }
//        		 else
//        		 {
//        			 e.setR(true);
//        			 return false;
//        		 }
//        	 }
//        	 else
//        	 {
//        		 e.setPass(true);
//        		 return false;
//        	 }
//         }
//         else
//         {
		return false;
//         }
//                
	}

		public List<Menu_Item> showMenu() {
		String[] fields = {"*"};
        HashMap<String, String> condition = new HashMap<String, String>();
        ResultSet resultSet = db.select("menu_item", fields, condition);
        List<Menu_Item> data = new ArrayList<Menu_Item>();
        //System.out.println(data);
        try {
			while(resultSet.next()) {
				Menu_Item members = new Menu_Item
						(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3), resultSet.getString(4), resultSet.getInt(5));
				data.add(members);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return data;
	}

	public boolean addToCart(Menu_Item item, String userId) {
		HashMap<String, String> conditions = new HashMap<String, String>();
		HashMap<String, String> data = new HashMap<String, String>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String[] field = { "item_id", "user_id", "quantity", "date", "time","token",
							"Vendor_id", "Tprice", "Status", "Msg" };
		String[] values = { Integer.toString(item.getItemId()), userId, "1",
		dtf.format(localDate), sdf.format(cal.getTime()), "0",Integer.toString(item.getVendorId()),
		Float.toString(item.getItemPrice()), "0", "" };
		boolean ins = db.insert("cms.order", field, values);
		if(ins)
		{
//			float a = (db.ae.get(0).getBalance()) - (m.getItemPrice());
//			data.put("user_balance", Float.toString(a));
//			conditions.put("user_id", Integer.toString(db.ae.get(0).getEmployeeId()));
//			boolean update = db.update("employee", data, conditions);
			return true;
		}
		
		return false;
	}

	public List<Cart> viewCart(int id) {
		
		String sql = "Select Order_id,mi.item_id, mi.item_name, quantity, date, Tprice, v.Vendor_Name, Status "
				+ "from cms.order o, menu_item mi, vendor v where o.item_id=mi.item_id and o.Vendor_id=v.Vendor_id and o.user_id='"+id+"' and Status='0'";
		ResultSet resultSet=db.select_query(sql);
		System.out.println(resultSet);
		List<Cart> data = new ArrayList<Cart>();
        //System.out.println(data);
        try {
			while(resultSet.next()) {
				Cart members = new Cart
						(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4), 
								resultSet.getDate(5), resultSet.getFloat(6), resultSet.getString(7), resultSet.getInt(8));
				data.add(members);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return data;
	}

	public void showOrder(int id) {
		HashMap<String, String> conditions = new HashMap<String, String>();
		HashMap<String, String> data = new HashMap<String, String>();
		String[] fields = { "*" };
		conditions.put("user_id", Integer.toString(id));
		conditions.put("Status", "0");
		db.select("cms.order", fields, conditions);

	}

	public boolean editOrder(int id, int q, float price) {
		HashMap<String, String> conditions = new HashMap<String, String>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("quantity", Integer.toString(q));
		data.put("Tprice", Float.toString(q * price));
		conditions.put("Order_id", Integer.toString(id));
		boolean update = db.update("cms.order", data, conditions);
		if (update) {
			return true;
		} else {
			return false;
		}
	}

	public List<Cart> deleteItem(int itemD, String userId)
	{
		boolean update = db.delete("cms.order", "Order_id", Integer.toString(itemD));
		return viewCart(Integer.parseInt(userId));
	}
	
	public boolean addBalance(float itemD, String userId)
	{
		HashMap<String, String> conditions = new HashMap<String, String>();
		HashMap<String, String> data = new HashMap<String, String>();
		
			data.put("user_balance", Float.toString(itemD));
			conditions.put("user_id", userId);
			return db.update("employee", data, conditions);
	}

	public List<Cart> checkOut(Cart[] itemD, String userId)
	{
		HashMap<String, String> data = new HashMap<String, String>();
		HashMap<String, String> conditions = new HashMap<String, String>();
		HashMap<String, String> data1 = new HashMap<String, String>();
		int[] condition=new int[itemD.length];
		String sql="select user_balance from employee where user_id = '"+userId+"'";
		float balance=0, userbalance=0;
		data.put("Status", "1");
		for(int i=0;i<itemD.length;i++)
		{
			 condition[i]= itemD[i].getOrderId();
			 balance=balance+itemD[i].getTotalPrice();
		}
		db.updateCheck("cms.order", data, "Order_id", condition);
		ResultSet resultSet=db.select_query(sql);
		try {
			while(resultSet.next()) {
				userbalance=resultSet.getFloat(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data1.put("user_balance", Float.toString(userbalance-balance));
		conditions.put("user_id", userId);
		 db.update("employee", data1, conditions);
		return viewCart(Integer.parseInt(userId));
	}

	public List<empTrans> getTrans(int id) {
		
		String sql = "Select Order_id,mi.item_id, mi.item_name, date, Tprice, v.Vendor_Name, Status "
				+ "from cms.order o, menu_item mi, vendor v where o.item_id=mi.item_id and o.Vendor_id=v.Vendor_id and o.user_id='"+id+"' and Status IN "
						+ "(1,2,3)";
		ResultSet resultSet=db.select_query(sql);
		System.out.println(resultSet);
		List<empTrans> data = new ArrayList<empTrans>();
        //System.out.println(data);
        try {
			while(resultSet.next()) {
				empTrans members = new empTrans
						(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), 
								resultSet.getDate(4), resultSet.getFloat(5), resultSet.getString(6), resultSet.getInt(7));
				data.add(members);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return data;
	}
}
