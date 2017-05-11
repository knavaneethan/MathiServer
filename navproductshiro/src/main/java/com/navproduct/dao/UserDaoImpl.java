package com.navproduct.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.navproduct.exception.NavDaoException;
import com.navproduct.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{


	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User getUser(String email) throws NavDaoException {
		User user = null;
        try{
	        Criteria cr = getSession().createCriteria(User.class);
	        cr.add(Restrictions.eq("email", email));
	        user = (User) cr.uniqueResult();	       
        }catch(Exception e){
        }
		return user;
	}

	@Override
	public List<User> getAllUsers() throws NavDaoException {
             
        Criteria cr = getSession().createCriteria(User.class);
         List<User> userList = cr.list();   
	return userList;
}

	@Override
	public void update(User user) throws NavDaoException {
		hibernateTemplate.update(user);		
	}

	@Override
	public User getUserByEmail(String email) throws NavDaoException {
		User user = (User) getSession().createQuery("from User where email=?").setString(0, email).uniqueResult();
		return user;
	}

	@Override
	public void save(User user) throws NavDaoException {
		hibernateTemplate.save(user);	
	}

	@Override
	public Boolean login(User user) throws NavDaoException {
		return false;
	}

}
