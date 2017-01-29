package com.cts.dao;

import java.sql.SQLException;

import com.cts.model.Users;

public interface UserDao {

	public Users fetchUserDetail(Users users) throws SQLException;

	public boolean insertUserDetail(Users users) throws SQLException;
}
