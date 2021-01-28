package com.simlilearning.workshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simplilearn.workshop.util.DatabaseConnection;

public class ProductDAO {
	
// Creating a connection
	Connection createConnection() {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.getConnection("jdbc:mysql://localhost/mydatabase", "root",
				"rootroot");
		return connection;
	}

	//Getting product by giving id
	public Product selectProduct(int id) {

		Product product = new Product();
		Connection connection = createConnection();

		try {
			String sql = "select id, name, price, detail from product where id = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);

			ResultSet rs = prepareStatement.executeQuery();
			if (rs.first()) {

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDetail(rs.getString("detail"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;

	}

}
