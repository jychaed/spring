package org.hdcd.controller.file.item01.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.ItemMapper;
import org.hdcd.vo.Item;
import org.springframework.stereotype.Service;

@Service
public class itemServiceImpl implements ItemService {

	@Inject
	private ItemMapper mapper;
	
	@Override
	public void register(Item item) throws Exception {
		mapper.create(item);

	}

	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Item read(int itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);
		
	}

	@Override
	public String getPicture(int itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	@Override
	public void remove(int itemId) throws Exception {
		mapper.delete(itemId);
		
	}

}
