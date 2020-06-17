package com.environment.server;

import java.util.Collection;
import java.util.Properties;

import com.environment.bean.Environment;
import com.environment.util.ConAttribute;
import com.environment.util.ConInstance;
import com.environment.util.Configuration;
import com.environment.util.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImp implements Server,ConInstance,ConAttribute{
	private ServerSocket server;
	private Socket client;
	private ObjectInputStream ois;
	private int port;
	private DBStore dbStore;
	private Log log;
	public ServerImp() {}
	
	@Override
	public void setConfiguration(Configuration con) {
		try {
			dbStore = con.getDbStore();
			log = con.getLogger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setProperties(Properties pro) {
		port = Integer.parseInt(pro.getProperty("port"));
	}
	@Override
	public void reciver() throws Exception {
		server = new ServerSocket(port);
		log.info("服务器开启");
		client = server.accept();
		log.info("开始接受数据");
	    ois = new ObjectInputStream(client.getInputStream());
		Collection<Environment> coll = (Collection)ois.readObject();
		log.info("接收数据完成");
		log.info("数据开始持久化");
		dbStore.saveDb(coll);
		log.info("持久化完成");
		shutdown();
		log.info("服务器关闭");
	}

	@Override
	public void shutdown() {
		try {
			if(server!=null) server.close();
			if(client!=null) client.close();
			if(ois!=null) ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
