package com.environment.server;

import java.util.Collection;

import com.environment.bean.Environment;
/**
 * DBStore�ṩ�����ģ��Ĺ淶��<br/>
 * �ýӿڵ�ʵ���ཫEnvironment���ϳ־û���
 */
public interface DBStore{
	/**
	 *   ���������ݼ��Ͻ��г־û� ��
	 * @param coll ��Ҫ�����Environment����
	 * @throws Exception
	 */
	public void saveDb(Collection<Environment> coll);
}
