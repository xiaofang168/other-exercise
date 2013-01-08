package com.fangj.exercise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlobUtils {
	private static Logger logger = LoggerFactory.getLogger(BlobUtils.class);
	static int count=1;

	public static void insertBlob(File pic,String tableName, String pp, String xh) {
		int inserId=count++;
		Connection conn = JdbcUtil.getConnection(
				"oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@192.168.1.118:1521:yppt", "jxyppt", "jxyppt");
		Statement st = null;
		ResultSet rs = null;
		OutputStream outStream = null;
		// 处理事务
		try {
//			conn.setAutoCommit(false);
			st = conn.createStatement();
			String id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
			// 插入一个空对象
			st.executeUpdate("insert into "+tableName+" (id,pp,xh,pic) values('" + inserId
					+ "','" + pp + "','" + xh + "',empty_blob())");
			// 用for update方式锁定数据行
			rs = st
					.executeQuery("select pic from "+tableName+" where id='" + inserId
							+ "' for update");
			if (rs.next()) {
				// 使用oracle.sql.BLOB类，没办法了，变成专用的了
				oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob("pic");
				// 到数据库的输出流
				outStream = blob.getBinaryOutputStream();
				// 这里用一个文件模拟输入流
//				File file = new File("d://proxy.txt");
				InputStream fin = new FileInputStream(pic);
				// 将输入流写到输出流
				byte[] b = new byte[blob.getBufferSize()];
				int len = 0;
				while ((len = fin.read(b)) != -1) {
					outStream.write(b, 0, len);
				}
			}
			outStream.flush();
			outStream.close();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.release(rs, st, conn);
		}

	}
}
