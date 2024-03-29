package com.cos.insta.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data //lombok
@Entity //JPA -> ORM
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 시퀀스
	private String username; // 유저 아이디
	private String password; // 암호화 필요
	private String name; // 유저 이름
	private String website; // 유저 홈페이지 주소
	private String bio; // 자기 소개 바이오
	private String email;
	private String phone;
	private String gender;
	private String profileImage; // 프로필 사진 경로 + 이름
	
	// (1) findById() 때만 동작
	// (2) findByUserInfo() 제외
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties({"user", "tags", "likes"}) // 순환참조 방지
	private List<Image> images = new ArrayList<>();
	
	@CreationTimestamp // 자동으로 현재 시간 세팅
	private Timestamp createDate; // import : sql
	@CreationTimestamp // 자동으로 현재 시간 세팅
	private Timestamp updateDate;
}
