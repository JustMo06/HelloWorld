package controller;

import model.AuthModel;
import view.AuthView;

public class AuthController {
	private AuthModel m = new AuthModel(this); //Create new AuthModel instance
	private AuthView v = new AuthView(this); //Create new AuthView instance
	
	public AuthModel getModel(){
		return this.m;
	}
	public AuthView getView(){
		return this.v;
	}
}
