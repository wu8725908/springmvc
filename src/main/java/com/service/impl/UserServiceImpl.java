//package com.service.impl;
//
//import com.dao.UserDao;
//import com.service.UserService;
//import com.cache.RedisCache;
//import com.entity.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	private UserDao userDao;
//	@Autowired
//	private RedisCache cache;
//
//
//	@Override
//	public List<User> getUserList(int offset, int limit) {
//		String cache_key=RedisCache.CAHCENAME+"|getUserList|"+offset+"|"+limit;
//		//先去缓存中取
//		List<User> result_cache=cache.getListCache(cache_key, User.class);
//		if(result_cache==null){
//			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
//			result_cache=userDao.queryAll(offset, limit);
//			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
//			LOG.info("put cache with key:"+cache_key);
//		}else{
//			LOG.info("get cache with key:"+cache_key);
//		}
//		return result_cache;
//	}
//
//
//
//}
