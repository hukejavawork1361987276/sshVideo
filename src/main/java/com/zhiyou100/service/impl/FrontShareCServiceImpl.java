package com.zhiyou100.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.BackDao;
import com.zhiyou100.dao.FrontShareCDao;
import com.zhiyou100.service.FrontShareCService;
@Service
public class FrontShareCServiceImpl implements FrontShareCService{
	@Autowired
	FrontShareCDao bd;
}
