package com.hs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hs.model.MemberDto;
import com.hs.service.MemberService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = {"*"})

public class MemberController {
	@Autowired
	MemberService memberService;
	
	@ApiOperation(value = "회원 가입", notes = "입력한 정보를 토대로 DB에 정보를 저장한다", response = Boolean.class)
	@PostMapping
	public ResponseEntity<Boolean> regist(@RequestBody Map<String, String> map){
		HttpStatus status = HttpStatus.ACCEPTED;
		
		// 회원 정보 담기
		MemberDto dto = new MemberDto();
		dto.setEmail(map.get("email"));
		dto.setName(map.get("name"));
		dto.setPassword(map.get("password"));
		
		try {
			memberService.join(dto);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Boolean>(status);
	}
}
