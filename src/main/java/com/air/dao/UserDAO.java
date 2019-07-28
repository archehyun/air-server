package com.air.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	public UserDAO() {
	//	try {				
		/*	sqlMap = SqlMapManager.getSqlMapInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	/*public List select() throws SQLException
	{
		return sqlMap.queryForList("tb_user.select");
	}
	
	protected SqlMapClient sqlMap;

	public int delete(String id) throws SQLException {
		
		UserInfo param = new UserInfo();
		param.setUser_id(id);
		return sqlMap.delete("tb_user.delete",param);
	}*/

}
