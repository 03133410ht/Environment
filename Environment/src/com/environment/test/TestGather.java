package com.environment.test;

import java.util.List;

import org.junit.Test;

import com.environment.bean.Environment;
import com.environment.client.GatherImp;
public class TestGather{
	
	@Test
	public void test2() throws Exception {
		GatherImp gatherImp = new GatherImp();
		int sum1 = 0;//�¶ȣ�ʪ��
		int sum2 = 0;//����
		int sum3 = 0;//������̼
		List<Environment> environments = gatherImp.gather();
		for (Environment environment : environments) {
			if("�¶�".equals(environment.getName())) {
				sum1+=1;
			}
			if("����".equals(environment.getName())) {
				sum2+=1;
			}
			if("������̼".equals(environment.getName())) {
				sum3+=1;
			}
		}
		System.out.println("�¶ȣ�"+sum1);
		System.out.println("ʪ�ȣ�"+sum1);
		System.out.println("���գ�"+sum2);
		System.out.println("������̼��"+sum3);
		System.out.println("�ܼƣ�"+environments.size());
	}
}
