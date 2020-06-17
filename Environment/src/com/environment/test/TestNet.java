package com.environment.test;

import java.util.List;

import org.junit.Test;

import com.environment.bean.Environment;
import com.environment.client.ClientImp;
import com.environment.client.GatherImp;
import com.environment.server.ServerImp;

public class TestNet {
	@Test
	public void server() throws Exception {
		ServerImp serverImp = new ServerImp();
		serverImp.reciver();
	}
	
	@Test
	public void client() throws Exception {
		ClientImp clientImp = new ClientImp();
		GatherImp gatherImp = new GatherImp();
		List<Environment> environments = gatherImp.gather();
		clientImp.send(environments);
	}
}
