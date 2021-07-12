package com.cloud.bbs.dto;

import java.sql.Timestamp;
import lombok.*;

@Getter
@Setter
@ToString
public class BBSDto {
	private int articleNum;
	private String id;
	private String title;
	private String content;
	private Timestamp writeDate;
	
}
