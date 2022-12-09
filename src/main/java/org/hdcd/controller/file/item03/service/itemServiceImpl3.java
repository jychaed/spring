package org.hdcd.controller.file.item03.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.ItemMapper3;
import org.hdcd.vo.Item3;
import org.hdcd.vo.item3Attach;
import org.springframework.stereotype.Service;

@Service
public class itemServiceImpl3 implements ItemService3 {
	
	@Inject
	private ItemMapper3 mapper;
	
	@Override
	public void register(Item3 item) throws Exception {
		mapper.create(item);
		
		String[] files = item.getFiles();
		if(files == null) {
			return;
		}
		
		for (String fileName : files) {
			fileName = fileName.replace("=", "");
			mapper.addAttach(fileName);
		}
	}

	@Override
	public List<Item3> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Item3 read(int itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public List<String> getAttach(int itemId) throws Exception {
		return mapper.getAttach(itemId);
	}

	@Override
	public void modify(Item3 item) throws Exception {
		mapper.update(item);
		int itemId = item.getItemId();
		mapper.deleteAttach(itemId); // 기존파일 날리고
		String[] files = item.getFiles();
		
		// 수정 셋업
		if(files == null) {
			return;
		}
		
		item3Attach item3Attach = new item3Attach();
		item3Attach.setItemId(itemId);
		for (String fileName : files) {
			fileName = fileName.replace("=", "");
			item3Attach.setFullname(fileName);
			mapper.replaceAttach(item3Attach);
		}
		
	}

	@Override
	public void remove(int itemId) throws Exception {
		mapper.deleteAttach(itemId);
		mapper.delete(itemId);
		
	}

	
	
	
	
}
