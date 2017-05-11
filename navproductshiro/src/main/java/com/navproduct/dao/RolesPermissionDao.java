package com.navproduct.dao;

import java.util.Set;

import com.navproduct.exception.NavDaoException;

public interface RolesPermissionDao {

	Set<String> getPermissionsByRoleNames(Set<String> roles) throws NavDaoException;
}
