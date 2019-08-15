package com.air;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.air.domain.LocationInfo;
import com.air.domain.TagInfo;
import com.air.mapper.LocationMapper;
import com.air.mapper.TagMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirServerApplicationTests {

	@Autowired
	private SqlSessionFactory sqlSession; //작성
	
	@Autowired
	TagMapper mapper;
	
	@Autowired
	LocationMapper locationMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSqlSession() throws Exception{//작성

		System.out.println("sqlSession : "+sqlSession);

	}

	@Test
	public void testSelect() throws Exception{//작성

		List li=mapper.selectTagList();
		System.out.println(li.size());

	}
	@Test
	public void testUserSelect() throws Exception{//작성

		List li=mapper.selectTagUser(new TagInfo());
		System.out.println("tag user:"+li.size());

	}
	
	@Test
	public void testLocationSelect() throws Exception{//작성

		List li=locationMapper.select(new LocationInfo());
		System.out.println("location:"+li.size());

	}

}
