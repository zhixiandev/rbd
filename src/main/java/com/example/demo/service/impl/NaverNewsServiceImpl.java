package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.collection.NaverKBLNews;
import com.example.demo.repository.NaverNewsRepository;
import com.example.demo.service.NaverNewsService;

@Service
public class NaverNewsServiceImpl implements NaverNewsService {

	@Autowired
	private NaverNewsRepository newsRepo;
	@Override
	public List<NaverKBLNews> newsList() {
		// TODO Auto-generated method stub
		return newsRepo.findAll();
	}

}
