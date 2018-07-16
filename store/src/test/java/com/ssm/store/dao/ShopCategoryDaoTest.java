package com.ssm.store.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.store.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest{
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory() {
		ShopCategory shopCategory = new ShopCategory();
		ShopCategory parent = new ShopCategory();
		parent.setShopCategoryId(10l);
		shopCategory.setParent(parent);
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
		assertEquals("二手市场", shopCategoryList.get(0).getShopCategoryName());
		
	}
	
}
