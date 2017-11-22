package com.air.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dao.TagDAO;
import com.air.domain.TagInfo;

@Service
public class TagService {
	
	@Autowired
	TagDAO dao;

	public void insert(TagInfo info)
	{
		System.out.println("insert");
	}
	public void delete()
	{
		
	}
	public void update(TagInfo info)
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
