package com.portfolio.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.portfolio.entity.User;
import com.portfolio.entity.UserDetailsInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.portfolio.exceptionHandling.InvalidJwtException;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private EntityManager entityManager;
	

	

	@Override
	@Transactional
	public UserDetailsInfo saveUserDetails(UserDetailsInfo userDetails) {
		entityManager.persist(userDetails);
		
		return userDetails;
	}
	
	
	
	@Override
	public User findUserByUserName(String userName){
		
		TypedQuery<User> query = entityManager.createQuery(" from User u LEFT JOIN FETCH u.leadInfo  where u.userName= :userName", User.class);
		
		query.setParameter("userName", userName);
		List<User> users = query.getResultList();
	
		if(users.size()>0) {
			return query.getResultList().get(0);
		}
		return null;
	}
	
	@Override
	@Transactional
	public User saveUser(User user, UserDetailsInfo userDetailsInfo) throws InvalidJwtException {
		entityManager.persist(user);
		User savedUser = this.findUserByUserName(user.getUsername());
		if(savedUser!=null) {
			userDetailsInfo.setUser(savedUser);
			
			entityManager.persist(userDetailsInfo);
		}
		else {
			throw new InvalidJwtException("User not found");
			
		}
		return user;
	}
	
	@Override
	public User findUserById(int id) {
		
		TypedQuery<User> query = entityManager.createQuery(" from User u LEFT JOIN FETCH u.leadInfo  where u.id= :id", User.class);
		
		query.setParameter("id", id);
		List<User> users = query.getResultList();
		if(users.size()>0) {
			return query.getResultList().get(0);
		}
		return null;
		

	}
	
	@Override
	@Transactional
	public UserDetailsInfo updateUserDetails(UserDetailsInfo userDetailsInfo) {
		return entityManager.merge(userDetailsInfo);
		
	}
	
}
