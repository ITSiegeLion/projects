package com.ssm.store.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.store.entity.Shop;



public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
		
	@Test
	public void testQueryShopById() {
		Shop shop = shopDao.queryByShopId(1l);
		System.out.println(shop.getShopName());
		
	}
}
