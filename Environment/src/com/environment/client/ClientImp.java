package com.environment.client;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

import com.environment.bean.Environment;
import com.environment.util.ConAttribute;
import com.environment.util.ConInstance;
import com.environment.util.Configuration;
import com.environment.util.Log;

public class ClientImp implements Client,ConAttribute,ConInstance{
	private Socket client;
	private String ip;
	private int port;
	private Log log;
	public ClientImp() {}
	@Override
	public void setConfiguration(Configuration con) {
		try {
			log = con.getLogger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setProperties(Properties pro) {
		ip = pro.getProperty("s_ip");
		port = Integer.parseInt(pro.getProperty("s_port"));
	}
	@Override
	public void send(Collection<Environment> coll) throws Exception {	
		client = new Socket(ip,port);
		log.info("连接服务器成功");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
		log.info("开始发送数据");
		objectOutputStream.writeObject(coll);
		log.info("发送完成");
		objectOutputStream.close();
		client.close();
	}

}
