package org.hdcd.controller.file.item02.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.ItemMapper2;
import org.hdcd.vo.Item2;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl2 implements ItemService2 {

	@Inject	
	private ItemMapper2 mapper;
	
	@Override
	public void register(Item2 item) throws Exception {
		mapper.create(item);
	}

	@Override
	public List<Item2> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Item2 read(int itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item2 item) throws Exception {
		mapper.update(item);
		
	}

	@Override
	public String getPicture(int itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	@Override
	public String getPicture2(int itemId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getPicture2(itemId);
	}

	@Override
	public void remove(int itemId) throws Exception {
		mapper.delete(itemId);
		
	}

}
