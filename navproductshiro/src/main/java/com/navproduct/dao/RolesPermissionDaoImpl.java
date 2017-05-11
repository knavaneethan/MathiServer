package com.navproduct.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.navproduct.exception.NavDaoException;
import com.navproduct.model.RolesPermission;

@Repository("rolesPermissionDao")
public class RolesPermissionDaoImpl extends AbstractDao implements RolesPermissionDao{


	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Set<String> getPermissionsByRoleNames(Set<String> roles) throws NavDaoException {
		 Criteria crit = getSession().createCriteria(RolesPermission.class);
		 crit.add(Restrictions.in("roleName", roles));
		 crit.setProjection(Projections.property("permission"));
		 return new HashSet<>(crit.list());
	}
}
