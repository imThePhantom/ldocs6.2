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

package com.liferay.adduser.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.adduser.service.http.UserInfoServiceSoap}.
 *
 * @author phantoan
 * @see com.liferay.adduser.service.http.UserInfoServiceSoap
 * @generated
 */
public class UserInfoSoap implements Serializable {
	public static UserInfoSoap toSoapModel(UserInfo model) {
		UserInfoSoap soapModel = new UserInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setCode(model.getCode());
		soapModel.setUsername(model.getUsername());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhone(model.getPhone());

		return soapModel;
	}

	public static UserInfoSoap[] toSoapModels(UserInfo[] models) {
		UserInfoSoap[] soapModels = new UserInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserInfoSoap[][] toSoapModels(UserInfo[][] models) {
		UserInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserInfoSoap[] toSoapModels(List<UserInfo> models) {
		List<UserInfoSoap> soapModels = new ArrayList<UserInfoSoap>(models.size());

		for (UserInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserInfoSoap[soapModels.size()]);
	}

	public UserInfoSoap() {
	}

	public String getPrimaryKey() {
		return _code;
	}

	public void setPrimaryKey(String pk) {
		setCode(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	private String _uuid;
	private long _groupId;
	private long _companyId;
	private long _creatorId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _code;
	private String _username;
	private String _email;
	private String _phone;
}