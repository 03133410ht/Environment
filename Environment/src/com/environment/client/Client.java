package com.environment.client;

import java.util.Collection;

import com.environment.bean.Environment;

/**
 *Client�ӿ��ǲɼ�ϵͳ����ģ��ͻ��˵Ĺ淶.<br/>
 *Client�����þ�����������˽���ͨ��,��������
 */
public interface Client{
	/**
	 * send����������������˽��н���������Environment�������������ˡ�
	 * @param coll
	 * @throws Exception
	 */
	public void send(Collection<Environment> coll)throws Exception;
}
