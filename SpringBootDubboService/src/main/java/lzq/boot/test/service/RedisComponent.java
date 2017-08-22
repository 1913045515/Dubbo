package lzq.boot.test.service;
import java.io.UnsupportedEncodingException;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.redis.core.RedisTemplate;  
import org.springframework.data.redis.core.StringRedisTemplate;  
import org.springframework.data.redis.core.ValueOperations;  
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lzq.boot.test.entity.User;  
@Component  
//@Service("redisService")
public class RedisComponent {  
    @Autowired  
    private RedisTemplate<String,Object> redisTemplate;  
    
    @Autowired  
    private StringRedisTemplate stringRedisTemplate;  

    public void set(String key, String value){  
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();  
        boolean bExistent = this.stringRedisTemplate.hasKey(key);  
        if (bExistent) {  
            System.out.println("this key is bExistent!");  
        }else{  
            ops.set(key, value);  
        }  
    }  
      
    public String get(String key){  
        return this.stringRedisTemplate.opsForValue().get(key);  
    }  
      
    public void del(String key){  
        this.stringRedisTemplate.delete(key);  
    }  
      
    public void sentinelSet(User user){  
        String key = null;  
        try {  
            key = new String(user.getId().getBytes("UTF-8"),"utf-8");  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        redisTemplate.opsForValue().set(key, user.toString());  
    }  
      
    public String sentinelGet(String key){  
        return stringRedisTemplate.opsForValue().get(key);  
    }  
}  
