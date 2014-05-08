package com.hallut.e_kvitto;

public final class Server {
	private static Server server;
	private String loggedInUser;
	
	private Server(){
		
	}
	
	public static Server getServer(){
		if(server!=null){
			return server;
		}else{
			server = new Server();
			return server;
		}
	}
	
	public String getLoggedInUser(){
		return loggedInUser;
	}
	
	public void logIn(String user){
		loggedInUser = user;
	}
		
}
