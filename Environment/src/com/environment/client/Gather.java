package com.environment.client;

import java.util.Collection;

import com.environment.bean.Environment;
/**
 *  Gather�ӿڹ涨�˲ɼ�ģ����Ӧ�еķ���.��Gatherִ��gather()����ʱ<br>
 * 	��ʼ�Ի�����Ϣ���вɼ�.���ɼ������ݷ�װ��Ϊһ��Environment�ļ��Ϸ���
 */
public interface Gather{
	/**
	  * �ɼ�������Ϣ�������ݷ�װΪEnvironment���Ϸ��ء�
	 * @return �ɼ���װEnvironment���ݵļ���
	 * @throws Exception
	 */
	public Collection<Environment> gather()throws Exception;
}
