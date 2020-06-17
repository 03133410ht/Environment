package com.environment.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;
import java.util.Collection;

import com.environment.bean.Environment;
import com.environment.util.ConnectionFactory;

public class DBStoreImp implements DBStore{
	private PreparedStatement statement;

	@Override
	public void saveDb(Collection<Environment> coll) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			int oldDay = 0;
			for (Environment environment : coll) {
				int day = environment.getGather_date().getDate();
				if(day!=oldDay) {
					if(statement!=null) {
						statement.executeBatch();
					}
					String sql = "insert into e_detail_" + day + " values(?,?,?,?,?,?,?,?,?)";
					statement = connection.prepareStatement(sql);
					oldDay = day;
				}
				addSql(environment);
			}
			
			if(statement!=null)
				statement.executeBatch();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement, connection);
		}
	}

	public void addSql(Environment environment) throws SQLException {
		statement.setString(1, environment.getName());
		statement.setString(2, environment.getSrcId());
		statement.setString(3, environment.getDstId());
		statement.setString(4, environment.getSersorAddress());
		statement.setInt(5, environment.getCount());
		statement.setString(6, environment.getCmd());
		statement.setInt(7, environment.getStatus());
		statement.setFloat(8, environment.getData());
		statement.setTimestamp(9, environment.getGather_date());
		statement.addBatch();
	}
	
}
