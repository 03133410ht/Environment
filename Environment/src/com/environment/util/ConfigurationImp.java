package com.environment.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.environment.client.Client;
import com.environment.client.Gather;
import com.environment.server.DBStore;
import com.environment.server.Server;

public class ConfigurationImp implements Configuration{
	static ConfigurationImp configurationImp = new ConfigurationImp();
	private Map<String, Object> map = null;
	Properties pro = null;
	private ConfigurationImp() {
		try {
			saxDocument();
			for(Object obj:map.values()) {
				if(obj instanceof ConInstance) {
					((ConInstance)obj).setConfiguration(this);
				}
				if(obj instanceof ConAttribute) {
					((ConAttribute)obj).setProperties(pro);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ConfigurationImp getInstance() {
		return configurationImp;
	}
	
	public  void saxDocument() throws Exception {
			map = new HashMap<>();
			pro = new Properties();
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser parser = saxParserFactory.newSAXParser();
			File file = new File("src/file/class.xml");
			parser.parse(file, new DefaultHandler() {
				String className;
				String classPath;
				String qName2;//×Ó±êÇ©Ãû
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					qName2 = qName;
					if(qName.equals("class")) {
						for(int i=0;i<attributes.getLength();i++) {
							pro.setProperty(attributes.getLocalName(i), attributes.getValue(i));
						}
					}
				}
				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if(qName.equals("class")) {
						try {
							Object obj = Class.forName(classPath).newInstance();
							map.put(className, obj);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					String name = new String(ch,start,length);
					if(!name.trim().equals("")) {
						if(!name.equals("\n")) {
							if(qName2.equals("classname"))
								className = name;
							if(qName2.equals("classpath"))
								classPath = name;
						}
					}
				}
			});
	}
	
	@Override
	public Log getLogger() throws Exception {
		return (Log)map.get("Log");
	}

	@Override
	public Server getServer() throws Exception {
		return (Server)map.get("Server");
	}

	@Override
	public Client getClient() throws Exception {
		return (Client)map.get("Client");
	}

	@Override
	public DBStore getDbStore() throws Exception {
		return (DBStore)map.get("DBStore");
	}

	@Override
	public Gather getGather() throws Exception {
		return (Gather)map.get("Gather");
	}
	
	@Override
	public BackUP getBackUP() throws Exception{
		return (BackUP)map.get("BackUP");
	}
}
