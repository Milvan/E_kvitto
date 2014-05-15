package com.hallut.e_kvitto;

/**
 * This would illustrate a server that keeps track of logged in user like sessions. 
 * This class could be refactored to hold the session and communication with a 
 * network server later when application connected to network.
 * 
 * There can only exist one instance of this class.
 * Access it by static method getServer()
 * 
 * @author Marcus
 *
 */
public final class Server {
	private static Server server;
	private String loggedInUser;
	
	
	/**
	 * Get this server object
	 * @return This server object
	 */
	public static Server getServer(){
		if(server!=null){
			return server;
		}else{
			server = new Server();
			return server;
		}
	}
	
	/**
	 * Get the currently logged in user.
	 * @return Username of currently logged in user.
	 */
	public String getLoggedInUser(){
		return loggedInUser;
	}
	
	/**
	 * Log in the given user.
	 * @param user The user that should be logged in.
	 */
	public void logIn(String user){
		loggedInUser = user;
	}
		
}
