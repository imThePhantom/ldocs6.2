/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.adduser.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.adduser.UserInfoCodeException;
import com.liferay.adduser.UserInfoEmailException;
import com.liferay.adduser.UserInfoPhoneException;
import com.liferay.adduser.UserInfoUsernameException;
import com.liferay.adduser.model.UserInfo;
import com.liferay.adduser.service.base.UserInfoLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the user info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.adduser.service.UserInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author phantoan
 * @see com.liferay.adduser.service.base.UserInfoLocalServiceBaseImpl
 * @see com.liferay.adduser.service.UserInfoLocalServiceUtil
 */
public class UserInfoLocalServiceImpl extends UserInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.adduser.service.UserInfoLocalServiceUtil} to access the user
	 * info local service.
	 */

	public UserInfo addUserInfo(String code, String username, String email,
			String phone, ServiceContext serviceContext)
			throws SystemException, PortalException {

		validate(code, username, email, phone);
		/*
		 * create user with default info: login with email password = code;
		 */

		UserInfo userInfo = userInfoPersistence.create(code);
		
		long creatorId = serviceContext.getUserId();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		Date now = new Date();
		User user = null;
		try {
			boolean autoPassword = false;
			String password1 = code;
			String password2 = code;
			boolean autoScreenName = false;
			String screenName = code;
			long facebookId = 0;
			String openId = "";
			Locale locale = Locale.US;
			int prefixId = 123;
			int suffixId = 234;
			boolean male = true;
			int birthdayMonth = 01;
			int birthdayDay = 01;
			int birthdayYear = 70;
			String jobTitle = "";
			boolean sendEmail = false;
			
			user = UserLocalServiceUtil.addUser(creatorId, companyId,
					autoPassword, password1, password2, autoScreenName,
					screenName, email, facebookId, openId, locale, username,
					"", "", prefixId, suffixId, male, birthdayMonth,
					birthdayDay, birthdayYear, jobTitle, null, null, null,
					null, sendEmail, serviceContext);

			userInfo.setUuid(serviceContext.getUuid());
			userInfo.setGroupId(groupId);
			userInfo.setCompanyId(companyId);
			userInfo.setCreatorId(creatorId);
			userInfo.setCreateDate(serviceContext.getCreateDate(now));
			userInfo.setModifiedDate(serviceContext.getModifiedDate(now));
			userInfo.setUserId(user.getUserId());
			userInfo.setUsername(username);
			userInfo.setEmail(email);
			userInfo.setPhone(phone);

			userInfoPersistence.update(userInfo);

		} catch (Exception e) {
			System.out.println("create liferay user fail");
		}
		return userInfo;
	}

	public List<UserInfo> getUserInfos(long groupId) throws SystemException {
		return userInfoPersistence.findBygroupId(groupId);
	}

	public List<UserInfo> getUserInfos(long groupId, int start, int end)
			throws SystemException {
		return userInfoPersistence.findBygroupId(groupId, start, end);
	}

	protected void validate(String code, String username, String email,
			String phone) throws PortalException {
		if (Validator.isNull(code)) {
			throw new UserInfoCodeException();
		}

		if (!Validator.isAlphanumericName(code)) {
			throw new UserInfoCodeException();
		}

		if (Validator.isNull(username)) {
			throw new UserInfoUsernameException();
		}

		if (!Validator.isEmailAddress(email)) {
			throw new UserInfoEmailException();
		}

		if (!Validator.isPhoneNumber(phone)) {
			throw new UserInfoPhoneException();
		}
	}
}