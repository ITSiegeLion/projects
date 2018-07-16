package com.ssm.store.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.store.dao.BaseTest;
import com.ssm.store.entity.Area;

public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService zoneService;
	
	@Test
	public void testGetZoneList(){
		List<Area> listZone = zoneService.getAreaList();
		assertEquals("深圳", listZone.get(0).getAreaName());
	}
}
