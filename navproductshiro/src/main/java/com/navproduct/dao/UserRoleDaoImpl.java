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
import com.navproduct.model.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao implements UserRoleDao{


	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Set<String> getUserRolesByEmail(String email) throws NavDaoException {
		 Criteria crit = getSession().createCriteria(UserRole.class);
		 crit.add(Restrictions.eq("email", email));
		 crit.setProjection(Projections.property("roleName"));
		 return new HashSet<>(crit.list());
//		 List<UserRole> roles = getSession().createQuery("from UserRole where email=?").setString(0, email).list();
//		 return roles;
	}

	@Override
	public void insert(UserRole r) throws NavDaoException {
		hibernateTemplate.save(r);
	}

}
