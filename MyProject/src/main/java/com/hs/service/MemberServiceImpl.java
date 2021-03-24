package com.hs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.model.MemberDto;
import com.hs.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void join(MemberDto dto) throws Exception {
		memberMapper.join(dto);
	}
   
}
