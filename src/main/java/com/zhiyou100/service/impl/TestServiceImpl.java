package com.zhiyou100.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.TestDao;
import com.zhiyou100.service.TestService;
		@Service
public class TestServiceImpl implements TestService {
		@Autowired
		TestDao td;

}
