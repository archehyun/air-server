package com.air.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.air.domain.LocationInfo;
import com.air.mapper.LocationMapper;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class LocationDAO {
	
	protected SqlMapClient sqlMap;
	
	@Autowired
	private LocationMapper mapper;
	
	public LocationDAO() {
		try {			
			sqlMap = SqlMapManager.getSqlMapInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List select() throws SQLException
	{
		return mapper.select(new LocationInfo());
		//return sqlMap.queryForList("tb_location.select", new LocationInfo());
	}

}
