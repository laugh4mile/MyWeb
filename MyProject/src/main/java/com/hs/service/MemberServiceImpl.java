package com.hs.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hs.model.MemberDto;
import com.hs.model.mapper.MemberMapper;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void join(MemberDto dto) {
		// TODO Auto-generated method stub 
		
	}
   
}
