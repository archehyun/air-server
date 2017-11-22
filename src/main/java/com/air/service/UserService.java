package com.air.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dao.UserDAO;
import com.air.domain.UserInfo;

@Service
public class UserService {
	
	@Autowired
	UserDAO dao;
	
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
	public void select()
	{
		try {
			List li = dao.select();
			System.out.println("size:"+li.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
