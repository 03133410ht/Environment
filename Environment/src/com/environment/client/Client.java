package com.environment.client;

import java.util.Collection;

import com.environment.bean.Environment;

/**
 *Client接口是采集系统网络模块客户端的规范.<br/>
 *Client的作用就是与服务器端进行通信,传递数据
 */
public interface Client{
	/**
	 * send方法用于与服务器端进行交互，发送Environment集合至服务器端。
	 * @param coll
	 * @throws Exception
	 */
	public void send(Collection<Environment> coll)throws Exception;
}
