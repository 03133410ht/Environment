package com.environment.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.environment.util.LogImp;

public class TestLog4j {
    public static Logger log=Logger.getLogger(TestLog4j.class);
    public static void main(String[] args){
    	PropertyConfigurator.configure ("log4j.properties") ;
        log.debug("debug信息");
        log.info("info信息");
        log.error("error信息");
    }
    
    
    @Test
    public void test1() {
    	LogImp logImp = new LogImp();
    	logImp.debug(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
    	logImp.info(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
    	logImp.error(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
    	logImp.warn(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
    	logImp.fatal(this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    
    @Test
    public void test2() {
    	Logger logger = Logger.getLogger(TestLog4j.class);
    	PropertyConfigurator.configure("log4j.properties");
    	logger.info("正常输出");
    }
}
