package com.environment.test;

import java.util.List;

import org.junit.Test;

import com.environment.bean.Environment;
import com.environment.client.GatherImp;
public class TestGather{
	
	@Test
	public void test2() throws Exception {
		GatherImp gatherImp = new GatherImp();
		int sum1 = 0;//温度，湿度
		int sum2 = 0;//光照
		int sum3 = 0;//二氧化碳
		List<Environment> environments = gatherImp.gather();
		for (Environment environment : environments) {
			if("温度".equals(environment.getName())) {
				sum1+=1;
			}
			if("光照".equals(environment.getName())) {
				sum2+=1;
			}
			if("二氧化碳".equals(environment.getName())) {
				sum3+=1;
			}
		}
		System.out.println("温度："+sum1);
		System.out.println("湿度："+sum1);
		System.out.println("光照："+sum2);
		System.out.println("二氧化碳："+sum3);
		System.out.println("总计："+environments.size());
	}
}
