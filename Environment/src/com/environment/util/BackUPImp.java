package com.environment.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BackUPImp implements BackUP,ConInstance{
	private Log log;
	
	@Override
	public void setConfiguration(Configuration con) {
		try {
			log = con.getLogger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Object load(String key, boolean flag) {
		Object obj = null;
		File file = null;
		ObjectInputStream ois = null;
		try {
			file = new File(key);
			ois = new ObjectInputStream(new FileInputStream(file));
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(flag) {
			file.delete();
			log.info("删除备份文件");
		}
		return obj;
	}

	@Override
	public void store(String key, Object data, boolean flag) {
		ObjectOutputStream oos = null;
        try {
			oos = new ObjectOutputStream(new FileOutputStream(key,flag));
			oos.writeObject(data);
        } catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}        		
	}
}
