package com.environment.client;

import java.util.List;
import java.util.Properties;

import com.environment.bean.Environment;
import com.environment.util.BackUP;
import com.environment.util.ConAttribute;
import com.environment.util.ConInstance;
import com.environment.util.Configuration;
import com.environment.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GatherImp implements Gather,ConAttribute,ConInstance{
	private List<Environment> list;
	private String filePath;
	private String backPath;
	private Log log;
	private BackUP backUP;
	@Override
	public void setProperties(Properties pro) {
		filePath = pro.getProperty("path");
		backPath = pro.getProperty("backPath");
	}
	@Override
	public void setConfiguration(Configuration con) {
		try {
			log = con.getLogger();
			backUP = con.getBackUP();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Environment> gather() throws Exception {
		list = new ArrayList<>();
		BufferedReader bufferedReader = null;
		File file = new File(filePath);
		bufferedReader = new BufferedReader(new FileReader(file));
		log.info("��ʼ��ȡ�ļ�");
		File backFile = new File(backPath);
		if(backFile.exists()) {
			Object obj = null;
			if(backFile.length()>0) {
				Long len = (Long)backUP.load(backPath, BackUP.LOAD_REMOVE);
				bufferedReader.skip(len);
			}
		}
		int tempCount = 0;//�¶�����
		int humCount = 0;//ʪ������
		int llCount = 0;//����ǿ��
		int co2Count = 0;//������̼
		String line = null;
		while((line=bufferedReader.readLine())!=null) {
			String[] msg = line.split("\\|");
			String name = "";
			String srcId = msg[0]; 
			String dstId = msg[1];
			String devId = msg[2];
			String sersorAddress = msg[3];
			int count = Integer.valueOf(msg[4]);
			String cmd = msg[5];
			String string = msg[6];
			int status = Integer.valueOf(msg[7]);
			float data = 0;
			Timestamp gather_date = new Timestamp(Long.valueOf(msg[8]));
			switch (sersorAddress) {
			case "16":
				name = "�¶�";
				data = Integer.parseInt(string.substring(0,4),16)*0.00268127F-46.85F;
				list.add(new Environment(name,srcId,dstId,devId,sersorAddress,count,cmd,status,data,gather_date));
				tempCount++;
				name = "ʪ��";
				data = Integer.parseInt(string.substring(4,8),16)*0.00190735F-6F;
				list.add(new Environment(name,srcId,dstId,devId,sersorAddress,count,cmd,status,data,gather_date));
				humCount++;
				break;
			case "256":
				name = "����";
				data = Integer.parseInt(string.substring(0,4),16);
				list.add(new Environment(name,srcId,dstId,devId,sersorAddress,count,cmd,status,data,gather_date));
				llCount++;
				break;
			case "1280":
				name = "������̼";
				data = Integer.parseInt(string.substring(0,4),16);
				list.add(new Environment(name,srcId,dstId,devId,sersorAddress,count,cmd,status,data,gather_date));
				co2Count++;
				break;
			}
		}
		log.info("��ȡ�ļ����");
		log.info("��ʼ�����ļ�");
		Long len = (Long)file.length();
		backUP.store(backPath, len, BackUP.STORE_OVERRIDE);
		log.info("�������");
		log.info("�¶�������:"+tempCount+"��");
		log.info("ʪ��������:"+humCount+"��");
		log.info("����ǿ������:"+llCount+"��");
		log.info("������̼Ũ����:"+co2Count+"��");
		log.info("�ܼƣ�"+list.size());
		bufferedReader.close();		
		return list;
	}
}
