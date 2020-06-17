package com.environment.test;

import java.util.Collection;

import org.junit.Test;

import com.environment.bean.Environment;
import com.environment.client.Client;
import com.environment.client.Gather;
import com.environment.server.Server;
import com.environment.util.ConfigurationImp;

public class TestConfiguration {
	@Test
	public void server() throws Exception {
		ConfigurationImp c = ConfigurationImp.getInstance();
		c.getServer().reciver();
	}

	@Test
	public void client() throws Exception {
		ConfigurationImp c = ConfigurationImp.getInstance();
		Collection<Environment> coll = c.getGather().gather();
		c.getClient().send(coll);
	}
}
