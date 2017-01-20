package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataDao {
	private Connection connection;

	public DataDao() throws Exception {
		connection = DBUtility.getConnection();
	}

	public ArrayList<String> getFrameWork(String CTRY_NAME) {
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String data;
		try {
			ps = connection
					.prepareStatement("SELECT * FROM Country  WHERE CTRY_NAME  LIKE ?");
			ps.setString(1, CTRY_NAME + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString("CTRY_NAME");
				list.add(data);
				System.out.println(list.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
