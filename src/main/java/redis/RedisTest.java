package redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by Fornia.fu on 2016/4/26.
 */
public class RedisTest
{
    public static void main(String[] args)
    {
        Jedis jedis = new Jedis("192.168.2.32",6380);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
        jedis.set("fornia","123");
        String value = jedis.get("fornia");
        System.out.println(value);
        jedis.del("fornia");
        System.out.println(jedis.get("fornia"));
        System.out.println(jedis.get("hello"));
        jedis.hset("map","name","fornia");
        jedis.hset("map","age","10");
        Map map = jedis.hgetAll("map");
        System.out.println(map.get("name"));
        System.out.println(jedis.hget("map","age"));
        jedis.rpush("rpush","rpush1","rpush3");
        jedis.rpush("rpush","rpush2");
        System.out.println(jedis.rpop("rpush"));
        System.out.println(jedis.rpop("rpush"));
        jedis.lpush("lpush","lpush1");
        jedis.lpush("lpush","lpush2");
        System.out.println(jedis.lrange("lpush",0,-1));
        System.out.println(jedis.lpop("lpush"));
    }
}
