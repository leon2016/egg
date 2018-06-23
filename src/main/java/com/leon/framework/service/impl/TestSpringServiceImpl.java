package com.leon.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leon.framework.service.ITestSpringService;
import com.leon.wx.bo.AddressBook;
import com.leon.wx.dao.AddressBookDao;

@Service
public class TestSpringServiceImpl implements ITestSpringService {
	@Autowired
	private AddressBookDao addressBookDao;

	@Override
	public String testSpring() {

		return "index";
	}

	@Override
	public AddressBook saveTest() {
		AddressBook book = new AddressBook();
		book.setAddress("测试");

		addressBookDao.save(book);
		book.setCity("sh");
		return book;
	}

}
