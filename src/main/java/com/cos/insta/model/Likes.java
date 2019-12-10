package com.cos.insta.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userId") // JoinColumn 안 걸면 user_id가 됨
	// id, username, profileImage 제외한 필드 Ignore
	@JsonIgnoreProperties({"images", "password", "name", "website", "bio", "email", "phone", "gender", "createDate", "updateDate"})
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "imageId")
	@JsonIgnoreProperties({"tags", "user", "likes"})
	private Image image;
	
	@CreationTimestamp
	private Timestamp createDate;
	@CreationTimestamp
	private Timestamp updateDate;
}
