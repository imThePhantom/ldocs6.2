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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserInfo}.
 * </p>
 *
 * @author phantoan
 * @see UserInfo
 * @generated
 */
public class UserInfoWrapper implements UserInfo, ModelWrapper<UserInfo> {
	public UserInfoWrapper(UserInfo userInfo) {
		_userInfo = userInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return UserInfo.class;
	}

	@Override
	public String getModelClassName() {
		return UserInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("code", getCode());
		attributes.put("username", getUsername());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}
	}

	/**
	* Returns the primary key of this user info.
	*
	* @return the primary key of this user info
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _userInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user info.
	*
	* @param primaryKey the primary key of this user info
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_userInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this user info.
	*
	* @return the uuid of this user info
	*/
	@Override
	public java.lang.String getUuid() {
		return _userInfo.getUuid();
	}

	/**
	* Sets the uuid of this user info.
	*
	* @param uuid the uuid of this user info
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userInfo.setUuid(uuid);
	}

	/**
	* Returns the group ID of this user info.
	*
	* @return the group ID of this user info
	*/
	@Override
	public long getGroupId() {
		return _userInfo.getGroupId();
	}

	/**
	* Sets the group ID of this user info.
	*
	* @param groupId the group ID of this user info
	*/
	@Override
	public void setGroupId(long groupId) {
		_userInfo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this user info.
	*
	* @return the company ID of this user info
	*/
	@Override
	public long getCompanyId() {
		return _userInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this user info.
	*
	* @param companyId the company ID of this user info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userInfo.setCompanyId(companyId);
	}

	/**
	* Returns the creator ID of this user info.
	*
	* @return the creator ID of this user info
	*/
	@Override
	public long getCreatorId() {
		return _userInfo.getCreatorId();
	}

	/**
	* Sets the creator ID of this user info.
	*
	* @param creatorId the creator ID of this user info
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_userInfo.setCreatorId(creatorId);
	}

	/**
	* Returns the create date of this user info.
	*
	* @return the create date of this user info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userInfo.getCreateDate();
	}

	/**
	* Sets the create date of this user info.
	*
	* @param createDate the create date of this user info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this user info.
	*
	* @return the modified date of this user info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _userInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this user info.
	*
	* @param modifiedDate the modified date of this user info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this user info.
	*
	* @return the user ID of this user info
	*/
	@Override
	public long getUserId() {
		return _userInfo.getUserId();
	}

	/**
	* Sets the user ID of this user info.
	*
	* @param userId the user ID of this user info
	*/
	@Override
	public void setUserId(long userId) {
		_userInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user info.
	*
	* @return the user uuid of this user info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this user info.
	*
	* @param userUuid the user uuid of this user info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the code of this user info.
	*
	* @return the code of this user info
	*/
	@Override
	public java.lang.String getCode() {
		return _userInfo.getCode();
	}

	/**
	* Sets the code of this user info.
	*
	* @param code the code of this user info
	*/
	@Override
	public void setCode(java.lang.String code) {
		_userInfo.setCode(code);
	}

	/**
	* Returns the username of this user info.
	*
	* @return the username of this user info
	*/
	@Override
	public java.lang.String getUsername() {
		return _userInfo.getUsername();
	}

	/**
	* Sets the username of this user info.
	*
	* @param username the username of this user info
	*/
	@Override
	public void setUsername(java.lang.String username) {
		_userInfo.setUsername(username);
	}

	/**
	* Returns the email of this user info.
	*
	* @return the email of this user info
	*/
	@Override
	public java.lang.String getEmail() {
		return _userInfo.getEmail();
	}

	/**
	* Sets the email of this user info.
	*
	* @param email the email of this user info
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_userInfo.setEmail(email);
	}

	/**
	* Returns the phone of this user info.
	*
	* @return the phone of this user info
	*/
	@Override
	public java.lang.String getPhone() {
		return _userInfo.getPhone();
	}

	/**
	* Sets the phone of this user info.
	*
	* @param phone the phone of this user info
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_userInfo.setPhone(phone);
	}

	@Override
	public boolean isNew() {
		return _userInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserInfoWrapper((UserInfo)_userInfo.clone());
	}

	@Override
	public int compareTo(com.liferay.adduser.model.UserInfo userInfo) {
		return _userInfo.compareTo(userInfo);
	}

	@Override
	public int hashCode() {
		return _userInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.adduser.model.UserInfo> toCacheModel() {
		return _userInfo.toCacheModel();
	}

	@Override
	public com.liferay.adduser.model.UserInfo toEscapedModel() {
		return new UserInfoWrapper(_userInfo.toEscapedModel());
	}

	@Override
	public com.liferay.adduser.model.UserInfo toUnescapedModel() {
		return new UserInfoWrapper(_userInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserInfoWrapper)) {
			return false;
		}

		UserInfoWrapper userInfoWrapper = (UserInfoWrapper)obj;

		if (Validator.equals(_userInfo, userInfoWrapper._userInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _userInfo.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserInfo getWrappedUserInfo() {
		return _userInfo;
	}

	@Override
	public UserInfo getWrappedModel() {
		return _userInfo;
	}

	@Override
	public void resetOriginalValues() {
		_userInfo.resetOriginalValues();
	}

	private UserInfo _userInfo;
}