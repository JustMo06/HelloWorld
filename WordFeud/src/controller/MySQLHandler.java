package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Timer;

public class MySQLHandler {
	private Statement con;
	private Timer t;
	
	public MySQLHandler(){
		this.checkConfig(); //Check if database configuration is present
		this.checkDriver(); //Check if the database driver is loaded
	}
	
	public void checkConfig(){
		if(Config.DB_HOSTNAME == "" || 
			Config.DB_PORT       < 1 || 
			Config.DB_USERNAME == "" || 
			Config.DB_PASSWORD == "" || 
			Config.DB_DATABASE == ""){
			System.err.println("ERROR! Please make sure your database settings are set correctly!");
			System.exit(1); //Quit application if requirements are not met
		}
	}
	
	public void checkDriver(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR! Please make sure your are launching this application with the MySQL connector!");
			System.exit(1); //Quit application if requirements are not met
		}
	}
	
	public void connect(){
		this.con = null; //Remove previous connection, if any
		
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://" + Config.DB_HOSTNAME + ":" + Config.DB_PORT + "/" + Config.DB_DATABASE, Config.DB_USERNAME, Config.DB_PASSWORD).createStatement();
		} catch (SQLException e) {
			System.out.println("ERROR! Unable to connect to database! Please check your database settings!");
			System.exit(1); //Quit application if unable to connect
		}
		this.keepAlive(); //Keep MySQL connection alive so we don't have to reconnect
	}
	
	public void keepAlive(){
		this.t.stop(); //Stop any previous timers to avoid DDoSsing the database server
		this.t = new Timer(25, e-> { //Create new timer to run every 25 seconds
			try{
				this.con.execute("/* ping */ SELECT 1"); //Send ping to MySQL server
			} catch (Exception err) {
				System.err.println("ERROR! Unable to start keepAlive function, database connection may be down!");
				System.err.println("Attempting reconnect...");
				this.connect();
			}
		});
		t.start();
	}
}
