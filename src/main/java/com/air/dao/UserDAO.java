package com.air.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.air.domain.UserInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class UserDAO {
	
	public UserDAO() {
		try {			
			sqlMap = SqlMapManager.getSqlMapInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List select() throws SQLException
	{
		return sqlMap.queryForList("tb_user.select");
	}
	
	protected SqlMapClient sqlMap;

	public int delete(String id) throws SQLException {
		
		UserInfo param = new UserInfo();
		param.setUser_id(id);
		return sqlMap.delete("tb_user.delete",param);
	}

}
