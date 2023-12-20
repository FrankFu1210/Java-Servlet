package tw.frank.tutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
//定義如果發生，做什麼事
@ServerEndpoint("/myserver")//myserver是一個websocket server
public class MyServer {
	private static HashSet<Session> sessions;//用不重複的資料結構，很重要! 裝很多sessions (用在藍芽偵測)
	private static HashMap<String, Session> users;//用Key(ID)來對應session，這邊ID不是INT很賊
	
	public MyServer() {//普通建構式，物件初始化(目前沒東西好寫沒事~)
		if (sessions == null) {//簡單初始化
			sessions = new HashSet<Session>();
			users = new HashMap<String, Session>();
		} 
	}
	
	//標註這方法是@OnOpen
	@OnOpen
	//也沒找人繼承，方法自己定義，session這個參數會被傳遞進來
	public void onOpen(Session session) {//定義到這邊，其他按照規定 (@ServerEndpoint底下的處理方式)
		System.out.println("onOpen:" + session.getId());//session代表這次的連線
		if (sessions.add(session)) {//沒重複丟進去，傳回true等於薪的連線
			users.put(session.getId(), session);//用資料結構去存放
			session.setMaxIdleTimeout(3*60*1000);//3分鐘把人趕走，測存活連線
		}
		System.out.println("Count:" + sessions.size());			
	}
	
	@OnClose
	public void onClose(Session session) {
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("Count:" + sessions.size());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println(session.getId() + ":" + message);
		
		//推播for each
		for (Session s : sessions) {
			try {
				s.getBasicRemote().sendText(message);//取得到遠端，去sendText文字資料		
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		//單獨發
		//users.get(session.getId()).getBasicRemote().sendText(message);
	}
}
