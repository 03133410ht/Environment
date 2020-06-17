package com.environment.util;
/**
 * 日志模块的实现类
 * @author 
 * 类中的方法表示： 不能场景下调用不同的方法。
 * 1.正常信息： info
 * 2.警告信息： warn
 * 3.报错信息：error
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
