package com.air.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dao.LocationDAO;
import com.air.domain.UserInfo;

public class LocationService {
	
	@Autowired
	LocationDAO dao;
	public void insert()
	{
		System.out.println("insert");
	}
	public void delete()
	{
		
	}
	public void update(UserInfo info)
	{
		
	}
	public List select()
	{
		try {
			return dao.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

}
