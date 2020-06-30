package com.three.web2.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 意见信息表
 */
@Document
public class Message {

	@Id
	int messageId;
	
	//学生id
	@DBRef
	Student stuId;
	
	//意见内容
	String messageContent;
	
	//时间
	String messageDate;
	
	//院系
	@DBRef
	Department	depId;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Student getStuId() {
		return stuId;
	}

	public void setStuId(Student stuId) {
		this.stuId = stuId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public Department getDepId() {
		return depId;
	}

	public void setDepId(Department depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", stuId=" + stuId + ", messageContent=" + messageContent
				+ ", messageDate=" + messageDate + ", depId=" + depId + "]";
	}
	
	
}
