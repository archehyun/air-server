package com.air.mapper;

import java.sql.SQLException;
import java.util.List;

import com.air.domain.TagInfo;


public interface TagMapper {
	
	public TagInfo selectTag(String tid)throws SQLException;
	public List selectTagList()throws SQLException;
	public void delete(String tid) throws SQLException;
	public void deleteTagUser(String tid, String user_id) throws SQLException;
	public List selectTagUser(TagInfo param)throws SQLException;
	

}
