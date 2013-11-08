package com.tistory.devyongsik.repository.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditingEntityListener {

	@PrePersist
	public void onPrePersist(Object o) {
		populateTimestamp(o);
	}
	
	@PreUpdate
	public void onPreUpdate(Object o) {
		populateTimestamp(o);
	}
	
	protected void populateTimestamp(Object o) {
		if (o instanceof AuditingEntity) {
			AuditingEntity auditingEntity = (AuditingEntity) o;
			if(auditingEntity.getRegDttm() == null) {
				auditingEntity.setRegDttm(new Date());
			} else {
				auditingEntity.setRegDttm(new Date());
			}
		}
	}
}
