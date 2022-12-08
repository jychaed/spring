package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Item;
import org.hdcd.vo.Item2;

public interface ItemMapper2 {
	public void create(Item2 item) throws Exception;

	public List<Item2> list() throws Exception;

	public Item2 read(int itemId) throws Exception;

	public void update(Item2 item) throws Exception;

	public String getPicture(int itemId) throws Exception;

	public String getPicture2(int itemId) throws Exception;

	public void delete(int itemId) throws Exception;
}
