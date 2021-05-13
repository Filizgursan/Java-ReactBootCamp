package Ecommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Ecommerce.dataAccess.abstracts.UserDao;
import Ecommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();
	User user = new User(1,"Filiz","G�RSAN","filiz@filiz.com","1234");

	@Override
	public void add(User user) {
		this.users.add(user); // User listesine g�nderilen user eklenir.
		System.out.println( user.getFirstName() + " kullan�c�s� sisteme eklendi.");
		
	}

	@Override
	public void delete(User user) {
		this.users.remove(user);
		System.out.println(user.getFirstName() + " kullan�c�s� sistemden silindi.");
		
	}

	@Override
	public void update(User user) {
		User usertoUpdate = getById(user.getId());
		usertoUpdate.setFirstName(user.getFirstName());
		usertoUpdate.setLastName(user.getLastName());
		usertoUpdate.setEmail(user.getEmail());
		usertoUpdate.setPassword(user.getPassword());
		System.out.println(user.getFirstName() + " kullan�c� bilgileri g�ncellenmi�tir.");		
	}

	
	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public boolean emailExist(User user) {
		for (User person : users) {
			if(person.getEmail() == user.getEmail()) {
				
				return true;
			}
				//return true;
			
		}
		return false;
	}

	@Override
	public User getById(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
