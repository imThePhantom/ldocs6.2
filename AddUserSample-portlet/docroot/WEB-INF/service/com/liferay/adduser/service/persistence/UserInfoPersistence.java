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

package com.liferay.adduser.service.persistence;

import com.liferay.adduser.model.UserInfo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see UserInfoPersistenceImpl
 * @see UserInfoUtil
 * @generated
 */
public interface UserInfoPersistence extends BasePersistence<UserInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserInfoUtil} to access the user info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user infos before and after the current user info in the ordered set where uuid = &#63;.
	*
	* @param code the primary key of the current user info
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo[] findByUuid_PrevAndNext(
		java.lang.String code, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user infos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.adduser.NoSuchUserInfoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user info where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the user info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user infos before and after the current user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param code the primary key of the current user info
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo[] findByUuid_C_PrevAndNext(
		java.lang.String code, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user infos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user infos where code = &#63;.
	*
	* @param code the code
	* @return the matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByuserCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user infos where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByuserCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user infos where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findByuserCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByuserCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByuserCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByuserCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByuserCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user infos where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos where code = &#63;.
	*
	* @param code the code
	* @return the number of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user infos before and after the current user info in the ordered set where groupId = &#63;.
	*
	* @param code the primary key of the current user info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo[] findBygroupId_PrevAndNext(
		java.lang.String code, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user infos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info where userId = &#63; or throws a {@link com.liferay.adduser.NoSuchUserInfoException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByuserId(long userId)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByuserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user info where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the user info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo removeByuserId(long userId)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user info in the entity cache if it is enabled.
	*
	* @param userInfo the user info
	*/
	public void cacheResult(com.liferay.adduser.model.UserInfo userInfo);

	/**
	* Caches the user infos in the entity cache if it is enabled.
	*
	* @param userInfos the user infos
	*/
	public void cacheResult(
		java.util.List<com.liferay.adduser.model.UserInfo> userInfos);

	/**
	* Creates a new user info with the primary key. Does not add the user info to the database.
	*
	* @param code the primary key for the new user info
	* @return the new user info
	*/
	public com.liferay.adduser.model.UserInfo create(java.lang.String code);

	/**
	* Removes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param code the primary key of the user info
	* @return the user info that was removed
	* @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo remove(java.lang.String code)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.adduser.model.UserInfo updateImpl(
		com.liferay.adduser.model.UserInfo userInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info with the primary key or throws a {@link com.liferay.adduser.NoSuchUserInfoException} if it could not be found.
	*
	* @param code the primary key of the user info
	* @return the user info
	* @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo findByPrimaryKey(
		java.lang.String code)
		throws com.liferay.adduser.NoSuchUserInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param code the primary key of the user info
	* @return the user info, or <code>null</code> if a user info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.adduser.model.UserInfo fetchByPrimaryKey(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user infos.
	*
	* @return the user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.adduser.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.adduser.model.UserInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user infos.
	*
	* @return the number of user infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}