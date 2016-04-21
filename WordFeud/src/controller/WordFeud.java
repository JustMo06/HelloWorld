package controller;

public class WordFeud {
	public static MySQLHandler db = new MySQLHandler();

	public static void main(String[] args) {
		new AuthController(); //Start new AuthController instance
	}

}
