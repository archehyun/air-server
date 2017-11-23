package com.air.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class TagDAO {
	
	public TagDAO() {
		try {			
			sqlMap = SqlMapManager.getSqlMapInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List select() throws SQLException
	{
		return sqlMap.queryForList("tb_tag.select");
	}
	
	protected SqlMapClient sqlMap;

}
