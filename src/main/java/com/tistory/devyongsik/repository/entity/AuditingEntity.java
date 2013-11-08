package com.tistory.devyongsik.repository.entity;

import java.util.Date;

public interface AuditingEntity {

	public Date getRegDttm();
	public void setRegDttm(Date regDttm);
	
}
