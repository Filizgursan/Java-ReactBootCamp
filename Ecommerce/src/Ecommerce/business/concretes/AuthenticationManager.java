package Ecommerce.business.concretes;

import Ecommerce.business.abstracts.AuthenticationService;
import Ecommerce.business.abstracts.UserService;
import Ecommerce.core.abstracts.SendMailService;
import Ecommerce.core.abstracts.SignUpService;
import Ecommerce.entities.concretes.User;

public class AuthenticationManager implements AuthenticationService {
	
	private UserService 	userService;
	private SendMailService sendMailService;
	private SignUpService 	signUpService;
	

	public AuthenticationManager(UserService userService, SendMailService sendMailService,SignUpService signUpService ) {
		this.userService 		= userService;
		this.sendMailService 	= sendMailService;
		this.signUpService  	= signUpService;
		
	}

	@Override
	public void signIn(User user) {
		User signInUser = userService.add(user);
		
		if(signInUser != null) {
			sendMailService.sendMail(user.getEmail());
		}
		
	}

	//kay�tol;
	@Override
	public void signUp(User user) {
		User signUpUser = userService.add(user);
		if(signUpUser != null) {
			System.out.println("Kay�t i�lemi ba�ar�yla ger�ekle�tirildi.");
		}
		
	}

	@Override
	public void signInWithGoogle(User user) {
		
		User signInWithGoogle = userService.add(user);
		if(signInWithGoogle != null) {
			sendMailService.sendMail(user.getEmail());
			signUpService.signUp(user);
		}
		
		
	}

}
