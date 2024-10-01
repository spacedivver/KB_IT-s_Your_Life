package com.multi.websocket.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Component("chatHandler")
public class ChatHandler extends TextWebSocketHandler {

	private Vector<WebSocketSession> memberList;
	private ConcurrentHashMap<String, WebSocketSession> map;

	public ChatHandler() {
		memberList = new Vector<>();
		map = new ConcurrentHashMap<String, WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결 성공!!");
		memberList.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message.getPayload());
		String type = element.getAsJsonObject().get("type").getAsString();

		if (type.equals("register")) {
			String memberId = element.getAsJsonObject().get("memberId").getAsString();
			map.put(memberId, session);
			boardCastMessage("공지",memberId + "님이 입장하였습니다.");
		} else if (type.equals("chat")) {
			String target = element.getAsJsonObject().get("target").getAsString();
			String msg = element.getAsJsonObject().get("msg").getAsString();
			String id = element.getAsJsonObject().get("id").getAsString();
			String answer = null;
			if(target == null || target.isEmpty()) { // 전체 메세지
				boardCastMessage(id, msg);
			}else { // 귓속말
				privateMessage(id, msg, target);
			}
		}
	}

	public void boardCastMessage(String id ,String msg){
		for(String key : map.keySet()) {
			try {
				WebSocketSession ws = map.get(key);
				if(!ws.isOpen()) {
					map.remove(key);
					continue;
				}
				ws.sendMessage(new TextMessage(id + " : " + msg));
			} catch (Exception e) {}
		}
	}

	public void privateMessage(String sendId, String msg, String target){
		WebSocketSession ws = map.get(target);
		if (ws != null) {
			try {
				if(!ws.isOpen()) {
					map.remove(target);
				}else {
					ws.sendMessage(new TextMessage(sendId + " : "+msg));
				}
			} catch (Exception e) {}
		}
	}

	//연결이 끊겼을 때 동작하는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료!!");
		memberList.remove(session);
	}
}
