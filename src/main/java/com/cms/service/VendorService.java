package com.cms.service;

import com.cms.connection.DbConnection;
import com.cms.model.DBStatus;

public class VendorService {
	public DbConnection db = new DbConnection();

	public DBStatus Login( String m_username,String  m_password) 
	{
        // boolean loginYes=true;

	 DbConnection db = new DbConnection();
	 DBStatus ds= new DBStatus();
     if(db.loginV(m_username,m_password))
     {
    	 ds.setStatus(true);
     }
     
     return ds;
	}
}
