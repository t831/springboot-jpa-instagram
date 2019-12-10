package com.cos.insta.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Image{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String location; //사진 촬영 위치
	private String caption; // 사진 설명
	private String postImage; //포스팅 사진 경로  + 이름
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"password", "images"}) // json 변환 시 제외 / Jackson library 적용 X
	private User user;
	
	// (1) Like List
	@OneToMany(mappedBy = "image") // mappedBy = "변수명"
	private List<Likes> likes = new ArrayList<>();
	
	// (2) Tag List
	@OneToMany(mappedBy = "image") // mappedBy = "변수명"
	@JsonManagedReference // 순환참조 방지
	private List<Tag> tags = new ArrayList<>();
	
	@Transient // DB에 영향 X (테이블 만들어도 추가 안 됨)
	private int likeCount;
	
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
	
}







