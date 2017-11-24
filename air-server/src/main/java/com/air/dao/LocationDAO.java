package com.air.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.air.domain.LocationInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class LocationDAO {
	
	protected SqlMapClient sqlMap;
	
	public LocationDAO() {
		try {			
			sqlMap = SqlMapManager.getSqlMapInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List select() throws SQLException
	{
		return sqlMap.queryForList("tb_location.select", new LocationInfo());
	}

}
