package com.environment.util;

public interface BackUP  {
	/**
	 * �ڱ�������ʱ����ԭ���ļ��Ļ����Ͻ���׷�ӡ� 
	 */
	public static final boolean STORE_APPEND=true;
	/**
	 * �ڱ�������ʱ������ԭ�����ļ�
	 */
	public static final boolean STORE_OVERRIDE=false;
	/**
	 * �ڶ�ȡ����ͬʱ��ɾ�������ļ�
	 */
	public static final boolean LOAD_REMOVE=true;
	/**
	 * �ڶ�ȡ����ͬʱ�����������ļ��� 
	 */
	public static final boolean LOAD_UNREMOVE=false;
	/**
	 * ͨ��������ȡ�Ѿ����ݵ�����
	 * @param key
	 * @param flag
	 * @return	
	 */                                                  
	Object load(String key,boolean flag);
	/**
	 * ͨ���������洢���ݡ�
	 * @param key
	 * @param data
	 * @param flag
	 */
	void store(String key,Object data,boolean flag);
}
