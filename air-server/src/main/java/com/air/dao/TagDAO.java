package com.air.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.air.domain.TagInfo;
import com.air.mapper.TagMapper;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class TagDAO {
	
	
	@Autowired
	TagMapper mapper;
	
	public TagDAO() {
		try {			
			sqlMap = SqlMapManager.getSqlMapInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TagInfo selectTag(String tid) throws SQLException
	{
		return mapper.selectTag(tid);
	}
	public List select() throws SQLException
	{
		return mapper.selectTagList();
		//return sqlMap.queryForList("tb_tag.select");
	}
	public List selectTagUser() throws SQLException
	{
		TagInfo param = new TagInfo();
/*		param.setTid(tid);
		param.setUser_id(user_id);*/
		
		return mapper.selectTagUser(param);
		//return sqlMap.queryForList("tb_tag.selectTagUser",param);
	}
	
	protected SqlMapClient sqlMap;

	public void delete(String tid) throws SQLException {
		
		TagInfo param = new TagInfo();
		
		param.setTid(tid);
		
		sqlMap.delete("tb_tag.delete",param);
		
	}

	public void deleteTagUser(String tid, String user_id) throws SQLException {
		TagInfo param = new TagInfo();
		
		param.setTid(tid);
		param.setUser_id(user_id);
		
		sqlMap.delete("tb_tag.deleteTagUser",param);
	}

}
