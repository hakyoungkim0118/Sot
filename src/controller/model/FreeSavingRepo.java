package controller.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class FreeSavingRepo implements AccountRepository<FreeSavings> {
	Connection conn;
	
	@Override
	public void insert(FreeSavings data) {
		conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rest = null;
		try {
			Date d = new Date(data.getCreateDate().getTimeInMillis());
			stmt = conn.prepareStatement("INSERT INTO FREESAVING VALUES (?,?,?,?,?)");
			stmt.setString(1, data.getAccountNumber());
			stmt.setString(2, data.getName());
			stmt.setInt(3, data.getPrice());
			stmt.setDate(4, d);
			stmt.setLong(5, data.getTotalAmount());
			rest = stmt.executeQuery();
		} catch (Exception e) {

		}
	}

}
