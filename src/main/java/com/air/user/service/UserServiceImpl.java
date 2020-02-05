package com.air.user.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dao.UserDAO;
import com.air.domain.UserInfo;
import com.air.user.service.impl.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	public void insert() { System.out.println("insert"); }
	
	/*
	 * @Autowired UserDAO dao;
	 * 
	 *  public void delete() {
	 * 
	 * } public void update(UserInfo info) {
	 * 
	 * } public List select() { try { List li = dao.select();
	 * System.out.println("size:"+li.size()); return li; } catch (SQLException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 * public void delete(String id) { try { dao.delete(id); } catch (SQLException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

}
