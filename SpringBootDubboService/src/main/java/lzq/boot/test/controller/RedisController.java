package lzq.boot.test.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lzq.boot.test.entity.User;
import lzq.boot.test.service.RedisComponent;
import lzq.boot.test.util.RedisUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Controller
// @RequestMapping("/BootTest")
public class RedisController {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RedisComponent redisComponet;

	@Value("${name}") 
	public String name;
	
	@RequestMapping("redisTest")
	@ResponseBody
	public String redisTest(){
		// 数据库链接池配置
		JedisPoolConfig config = new JedisPoolConfig(); 
		config.setMaxTotal(100); 
		config.setMaxIdle(50); 
		config.setMinIdle(20); 
		config.setMaxWaitMillis(6 * 1000); 
		config.setTestOnBorrow(true); 
		// Redis集群的节点集合
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));
		jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));
		jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6382));
		// 根据节点集创集群链接对象
		//JedisCluster jedisCluster = newJedisCluster(jedisClusterNodes);
		// 节点，超时时间，最多重定向次数，链接池
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 2000, 100,config);
		jedisCluster.set("key1", "test shuju1");
		jedisCluster.set("key2", "test shuju2");
		jedisCluster.set("key3", "test shuju3");
//		System.out.println("name::"+jedisCluster.get("name"));
//		System.out.println("key:"+jedisCluster.get("key"));
//		System.out.println("nokey1:"+jedisCluster.get("nokey1"));
		return "success";
	}
	@RequestMapping("test")
	@ResponseBody
	public String test() {
//		System.out.println(name);
//		RedisUtil.getJedis().set("newname", "中文测试");
//		System.out.println(RedisUtil.getJedis().get("name"));
//		System.out.println(RedisUtil.getJedis().get("key"));
		
		// 生成多机连接信息列表
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add( new JedisShardInfo("127.0.0.1", 6380) );
		shards.add( new JedisShardInfo("127.0.0.1", 6381) );
		shards.add( new JedisShardInfo("127.0.0.1", 6382) );

		// 生成连接池配置信息
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(10);
		config.setMaxTotal(30);
		config.setMaxWaitMillis(3*1000);

		// 在应用初始化的时候生成连接池
		ShardedJedisPool pool = new ShardedJedisPool(config, shards);

		// 在业务操作时，从连接池获取连接
		ShardedJedis client = pool.getResource();
		String keyValue="",nameValue="";
		try {
		    // 执行指令
//		    String result = client.set("key-string", "Hello, Redis!");
//		    System.out.println( String.format("set指令执行结果:%s", result) );
		    keyValue = client.get("key");
		    nameValue = client.get("name");
		    System.out.println( String.format("get指令执行结果:%s", keyValue) );
		    System.out.println( String.format("get指令执行结果:%s", nameValue) );
		} catch (Exception e) {
		    // TODO: handle exception
		} finally {
		    // 业务操作完成，将连接返回给连接池
		    if (null != client) {
		        pool.returnResource(client);
		    }
		} // end of try block
		// 应用关闭时，释放连接池资源
		pool.destroy();
		return "success";
	}
	
	@RequestMapping("redisInfo")
	@ResponseBody
	public String getRedisInfo(String key) {
		String result = "";
		// 保存对象
		result = redisTemplate.opsForValue().get(key) + "";
		return result;
	}

	@RequestMapping("saveInfo")
	@ResponseBody
	public String saveRedisInfo(String key, String value) {
		// 保存对象
		redisTemplate.opsForValue().set(key, value);
		return "save is success and save key is :" + key + " save value is:" + value;
	}

	@RequestMapping("sentinelSet")
	@ResponseBody
	public String sentinelSet(String id,String name) {
		User user = new User();
		user.setId(id);
		user.setAge("30");
		user.setName(name);
		redisComponet.sentinelSet(user);
		return "success";
	}

	@RequestMapping("sentinelGet")
	@ResponseBody
	public String sentinelGet(String id) {
		String str = redisComponet.sentinelGet(id);
		return str;
	}
}
