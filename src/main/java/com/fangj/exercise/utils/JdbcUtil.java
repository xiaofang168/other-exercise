package com.fangj.exercise.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc连接数据库工具类
 * @author 申路国
 */
public class JdbcUtil {
	/**
	 * 根据参数获取数据库连接
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public static Connection getConnection(String driver,String url,String username,String password){
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("加载oracle驱动出错。");
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("创建数据库连接失败，请检查参数是否配置正确。");
		}
		return conn;
	}
	
	/**
	 * 释放资源,释放数据库连接
	 * @param rs
	 * @param stm
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement stm, Connection conn) {
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭ResultSet出错");
			}
		}
		if (stm != null){
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭Statement出错");
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭Connection出错");
			}
		}
	}
}
