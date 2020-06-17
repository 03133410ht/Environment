package com.environment.util;
/**
 * �ýӿ��ṩ����־ģ��Ĺ淶�� ��־ģ�齫��־��Ϣ����Ϊ���ּ���<br/>
 * ���岻ͬ�������־�ļ�¼�ĸ�ʽ����¼��ʽ�������о���ʵ����������
 */
public interface Log{
	/**
	 * ��¼Debug�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void debug(String message);
	/**
	 * ��¼Info�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void info(String message);
	/**
	 * ��¼Warn�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void warn(String message);
	/**
	 * ��¼Error�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void error(String message);
	/**
	 * ��¼Fatal�������־
	 * @param message ��Ҫ��¼����־��Ϣ
	 */
	public void fatal(String message);
}
