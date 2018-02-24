package com.bfwk.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint("/websocket")
public class WebSocketController {
	Logger logger=Logger.getLogger(WebSocketController.class);
	private Session session;
	private CopyOnWriteArraySet<WebSocketController> webSocketSet=new CopyOnWriteArraySet<WebSocketController>();
	
	@OnOpen
	public void onOpen(Session session) {
		this.session=session;
		webSocketSet.add(this);
		logger.info("websocket open success!");
		
	}
	
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		logger.info("websocket closed !");
		
	}
	
	@OnMessage
	public void onMessage(String message) {
		logger.info("receive message from client "+message);
	}
	
	public void sendMessage(String message) {
		 for(WebSocketController webSocketController:webSocketSet) {
			 try {
				 logger.info("send Message "+message);
				 webSocketController.session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	}
}
