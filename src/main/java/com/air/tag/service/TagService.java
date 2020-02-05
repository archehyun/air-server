package com.air.tag.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.dao.TagDAO;
import com.air.domain.TagInfo;


public interface TagService {
	
	public void insert(TagInfo info);
	
	/*
	 * @Autowired TagDAO dao;
	 * 
	 * public void insert(TagInfo info) { System.out.println("insert"); } public
	 * void delete(String tid) { try { dao.delete(tid); } catch (SQLException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } } public void
	 * deleteTagUser(String tid, String user_id) { try {
	 * dao.deleteTagUser(tid,user_id); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } } public void
	 * update(TagInfo info) {
	 * 
	 * } public List select() { try { return dao.select(); } catch (SQLException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 * public List selectTagUser() { try { return dao.selectTagUser(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return null; }
	 */
}
