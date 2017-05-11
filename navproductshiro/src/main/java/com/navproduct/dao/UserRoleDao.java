package com.navproduct.dao;

import java.util.List;
import java.util.Set;

import com.navproduct.exception.NavDaoException;
import com.navproduct.model.UserRole;

public interface UserRoleDao {

	public Set<String> getUserRolesByEmail(String email) throws NavDaoException;

	public void insert(UserRole r) throws NavDaoException;
}
