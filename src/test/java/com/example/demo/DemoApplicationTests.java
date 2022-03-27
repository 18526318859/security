package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

	//注入数据库配置信息


	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;
	@Test
	void contextLoads() {
		Connection connection = null;
		try {
			//调用getConnection ( )进行数据连接
			connection = dataSource.getConnection ( );
		} catch (SQLException e) {
			e.printStackTrace ( );
		}
		System.out.println (connection );
		try {
			connection.close ();
		} catch (SQLException e) {
			e.printStackTrace ( );
		}


	}

}
