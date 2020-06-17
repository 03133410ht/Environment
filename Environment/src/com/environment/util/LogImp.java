package com.environment.util;
/**
 * ��־ģ���ʵ����
 * @author 
 * ���еķ�����ʾ�� ���ܳ����µ��ò�ͬ�ķ�����
 * 1.������Ϣ�� info
 * 2.������Ϣ�� warn
 * 3.������Ϣ��error
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class LogImp implements Log{
//	public static Logger log =Logger.getLogger(LogImp.class);
	public static Logger log = Logger.getRootLogger();
	static {
		PropertyConfigurator.configure ("log4j.properties") ;
	}
	@Override
	public void debug(String message) {
		log.debug(message);
	}

	@Override
	public void info(String message) {
	    log.info(message);
	}

	@Override
	public void warn(String message) {
		log.warn(message);
	}

	@Override
	public void error(String message) {
		log.error(message);
	}

	@Override
	public void fatal(String message) {
		log.fatal(message);
	}
}
