package com.environment.util;

import com.environment.client.Client;
import com.environment.client.Gather;
import com.environment.server.DBStore;
import com.environment.server.Server;
/**
 * Configuration�ӿ��ṩ������ģ��Ĺ淶�� ����ģ��ͨ��ĳ�����÷�ʽ��Logger<br/>
 * Gather��Client��Server��DBStore��ģ���ʵ�������ʵ������ ���ҽ�������Ҫ������Ϣ����<br/>
 * ���ݡ�ͨ������ģ����Ի�ø���ģ���ʵ����
 */
public interface Configuration {
	/**
	 * ��ȡ��־ģ���ʵ��
	 * @return ��־����
	 * @throws Exception
	 */
	public Log getLogger()throws Exception;
	/**
	 * ��ȡ�������˵�ʵ��
	 * @return ����������
	 * @throws Exception
	 */
	public Server getServer()throws Exception;
	/**
	 * ��ȡ�ͻ��˵�ʵ��
	 * @return  �ͻ��˶���
	 * @throws Exception
	 */
	public Client getClient()throws Exception;
	/**
	 * ��ȡ���ģ���ʵ��
	 * @return  ������
	 * @throws Exception
	 */
	public DBStore getDbStore()throws Exception;
	/**
	 * ��ȡ�ɼ�ģ���ʵ��
	 * @return  �ɼ�����
	 * @throws Exception
	 */
	public Gather getGather()throws Exception;
	/**
	 * ��ȡ����ģ��ʵ��
	 * @return ���ݶ���
	 * @throws Exception
	 */
	public BackUP getBackUP()throws Exception;
}
