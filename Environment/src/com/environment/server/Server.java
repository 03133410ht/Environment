package com.environment.server;

import java.util.Collection;

import com.environment.bean.Environment;
/**
 * Server�ӿ��ṩ�˲ɼ�ϵͳ����ģ��������˵ı�׼�� Server��ʵ����<br/>
 * ��Ҫʵ����ɼ����Ϳͻ��˽��н�����������DBStore�����յ����ݳ־û���<br/>
 * ��Server��ʵ����ִ��revicer()����ʱ��Server��ʼ�����˿ڡ�
 */
public interface Server{
	/**
	 * �÷��������������Server���񣬿�ʼ���տͻ��˴��ݵ���Ϣ��<br/>
	 * ���ҵ���DBStore�����յ����ݳ־û�
	 * @return ���ܵ�Environment���ݵļ���
	 * @throws Exception
	 */
	public void reciver()throws Exception;
	/**
	 * �÷�������ʹServer��ȫ��ֹͣ���С�
	 */
	public void shutdown();
}
