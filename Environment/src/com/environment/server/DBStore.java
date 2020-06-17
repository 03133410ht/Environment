package com.environment.server;

import java.util.Collection;

import com.environment.bean.Environment;
/**
 * DBStore提供了入库模块的规范。<br/>
 * 该接口的实现类将Environment集合持久化。
 */
public interface DBStore{
	/**
	 *   将环境数据集合进行持久化 。
	 * @param coll 需要储存的Environment集合
	 * @throws Exception
	 */
	public void saveDb(Collection<Environment> coll);
}
