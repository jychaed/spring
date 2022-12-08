package org.hdcd.controller.file.item01.service;

import java.util.List;

import org.hdcd.vo.Item;

public interface ItemService {

	public void register(Item item) throws Exception;

	public List<Item> list() throws Exception;

	public Item read(int itemId) throws Exception;

	public void modify(Item item) throws Exception;

	public String getPicture(int itemId) throws Exception;

	public void remove(int itemId) throws Exception;


		

	

}
