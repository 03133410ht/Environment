package com.environment.client;

import java.util.Collection;

import com.environment.bean.Environment;
/**
 *  Gather接口规定了采集模块所应有的方法.当Gather执行gather()方法时<br>
 * 	开始对环境信息进行采集.将采集的数据封装成为一个Environment的集合返回
 */
public interface Gather{
	/**
	  * 采集环境信息，将数据封装为Environment集合返回。
	 * @return 采集封装Environment数据的集合
	 * @throws Exception
	 */
	public Collection<Environment> gather()throws Exception;
}
