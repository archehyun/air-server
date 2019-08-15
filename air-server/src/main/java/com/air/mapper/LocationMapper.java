package com.air.mapper;

import java.sql.SQLException;
import java.util.List;

import com.air.domain.LocationInfo;

public interface LocationMapper {
	public List select(LocationInfo locationInfo) throws SQLException;

}
