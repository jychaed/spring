package org.hdcd.controller.file.item03.service;

import java.util.List;

import org.hdcd.vo.Item3;

public interface ItemService3 {

	public void register(Item3 item) throws Exception;

	public List<Item3> list() throws Exception;

	public Item3 read(int itemId) throws Exception;

	public List<String> getAttach(int itemId) throws Exception;

	public void modify(Item3 item) throws Exception;

	public void remove(int itemId) throws Exception;

}
