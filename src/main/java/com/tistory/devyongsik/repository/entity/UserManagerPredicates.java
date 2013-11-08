package com.tistory.devyongsik.repository.entity;

import com.mysema.query.types.expr.BooleanExpression;

public class UserManagerPredicates {

	public static BooleanExpression hasUsers() {
		return QUserManager.userManager.users.isNotEmpty();
	}
}
