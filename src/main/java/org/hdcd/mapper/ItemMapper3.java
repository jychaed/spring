package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Item3;
import org.hdcd.vo.item3Attach;

public interface ItemMapper3 {

	public void create(Item3 item) throws Exception;

	public void addAttach(String fileName) throws Exception;

	public List<Item3> list() throws Exception;

	public Item3 read(int itemId) throws Exception;

	public List<String> getAttach(int itemId) throws Exception;

	public void update(Item3 item) throws Exception;

	public void deleteAttach(int itemId) throws Exception;

	public void replaceAttach(item3Attach item3Attach) throws Exception;

	public void delete(int itemId) throws Exception;
}
