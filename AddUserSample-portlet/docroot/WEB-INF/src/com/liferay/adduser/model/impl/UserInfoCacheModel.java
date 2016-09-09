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

package com.liferay.adduser.model.impl;

import com.liferay.adduser.model.UserInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserInfo in entity cache.
 *
 * @author phantoan
 * @see UserInfo
 * @generated
 */
public class UserInfoCacheModel implements CacheModel<UserInfo>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", username=");
		sb.append(username);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserInfo toEntityModel() {
		UserInfoImpl userInfoImpl = new UserInfoImpl();

		if (uuid == null) {
			userInfoImpl.setUuid(StringPool.BLANK);
		}
		else {
			userInfoImpl.setUuid(uuid);
		}

		userInfoImpl.setGroupId(groupId);
		userInfoImpl.setCompanyId(companyId);
		userInfoImpl.setCreatorId(creatorId);

		if (createDate == Long.MIN_VALUE) {
			userInfoImpl.setCreateDate(null);
		}
		else {
			userInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userInfoImpl.setModifiedDate(null);
		}
		else {
			userInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		userInfoImpl.setUserId(userId);

		if (code == null) {
			userInfoImpl.setCode(StringPool.BLANK);
		}
		else {
			userInfoImpl.setCode(code);
		}

		if (username == null) {
			userInfoImpl.setUsername(StringPool.BLANK);
		}
		else {
			userInfoImpl.setUsername(username);
		}

		if (email == null) {
			userInfoImpl.setEmail(StringPool.BLANK);
		}
		else {
			userInfoImpl.setEmail(email);
		}

		if (phone == null) {
			userInfoImpl.setPhone(StringPool.BLANK);
		}
		else {
			userInfoImpl.setPhone(phone);
		}

		userInfoImpl.resetOriginalValues();

		return userInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		code = objectInput.readUTF();
		username = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (username == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}
	}

	public String uuid;
	public long groupId;
	public long companyId;
	public long creatorId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String code;
	public String username;
	public String email;
	public String phone;
}