package model;

import controller.AuthController;

public class AuthModel {
	private AuthController c;
	
	public AuthModel(AuthController c){
		this.c = c;
	}
	
	public AuthController getController(){
		return this.c;
	}
}
