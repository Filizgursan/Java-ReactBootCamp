package Ecommerce.core.concretes;

import java.util.Random;

import Ecommerce.core.abstracts.SendMailService;

public class SendMailManager implements SendMailService{
	
	Random rnd = new Random();
	
	@Override
	public int generateVerificationCode() {
		
		//do�rulama kodu al�n�r;
		int code = rnd.nextInt(9999);
		return code;
	}
	@Override
	public int sendMail(String email) {
		int code = generateVerificationCode();
		System.out.println("Email : " + email + "\nDo�rulama Kodu: " + code);
		return code;
		
	}



}
