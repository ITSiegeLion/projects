package com.ssm.store.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.store.dto.ImageHolder;
import com.ssm.store.dto.ShopExecution;
import com.ssm.store.entity.Area;
import com.ssm.store.entity.PersonInfo;
import com.ssm.store.entity.Shop;
import com.ssm.store.entity.ShopCategory;
import com.ssm.store.enums.ShopStateEnum;
import com.ssm.store.service.ShopService;

public class ShopServiceTest extends BaseTest{

	@Autowired
	private ShopService shopService;
	
	@Test
	public void testShopService() throws Exception {
		 Shop shop = new Shop();
		 PersonInfo owner = new PersonInfo();
		 Area area = new Area();
		 ShopCategory shopCategory = new ShopCategory();
		 owner.setUserId(1l);
		 area.setAreaId(3);
		 shopCategory.setShopCategoryId(27l);
		 
		 shop.setArea(area);
		 shop.setShopCategory(shopCategory);
		 shop.setOwner(owner);
		 shop.setShopName("cols眼镜");
		 shop.setShopDesc("让你的视力回归5.0");
		 shop.setShopAddr("test");
		 shop.setPhone("131686722356");
		 shop.setCreateTime(new Date());
		 shop.setLastEditTime(new Date());
		 shop.setAdvice("正在审核……");
		 File shopImg = new File("D:/project/cos.jpg");
		 InputStream is = new FileInputStream(shopImg);
		 ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
		 ShopExecution shopExecution = shopService.addShop(shop,imageHolder);
		 assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());
	}
}
