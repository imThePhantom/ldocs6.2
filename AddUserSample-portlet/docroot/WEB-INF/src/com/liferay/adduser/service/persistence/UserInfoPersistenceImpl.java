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

import com.liferay.adduser.NoSuchUserInfoException;
import com.liferay.adduser.model.UserInfo;
import com.liferay.adduser.model.impl.UserInfoImpl;
import com.liferay.adduser.model.impl.UserInfoModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the user info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see UserInfoPersistence
 * @see UserInfoUtil
 * @generated
 */
public class UserInfoPersistenceImpl extends BasePersistenceImpl<UserInfo>
	implements UserInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserInfoUtil} to access the user info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserInfoModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserInfo> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<UserInfo> list = (List<UserInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserInfo userInfo : list) {
				if (!Validator.equals(uuid, userInfo.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserInfo>(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByUuid_First(uuid, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserInfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByUuid_Last(uuid, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public UserInfo[] findByUuid_PrevAndNext(String code, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = findByPrimaryKey(code);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userInfo, uuid,
					orderByComparator, true);

			array[1] = userInfo;

			array[2] = getByUuid_PrevAndNext(session, userInfo, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserInfo getByUuid_PrevAndNext(Session session,
		UserInfo userInfo, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (UserInfo userInfo : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userInfo.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userInfo.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userInfo.uuid IS NULL OR userInfo.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			UserInfoModelImpl.UUID_COLUMN_BITMASK |
			UserInfoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the user info where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.adduser.NoSuchUserInfoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByUUID_G(String uuid, long groupId)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByUUID_G(uuid, groupId);

		if (userInfo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserInfoException(msg.toString());
		}

		return userInfo;
	}

	/**
	 * Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof UserInfo) {
			UserInfo userInfo = (UserInfo)result;

			if (!Validator.equals(uuid, userInfo.getUuid()) ||
					(groupId != userInfo.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<UserInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					UserInfo userInfo = list.get(0);

					result = userInfo;

					cacheResult(userInfo);

					if ((userInfo.getUuid() == null) ||
							!userInfo.getUuid().equals(uuid) ||
							(userInfo.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, userInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserInfo)result;
		}
	}

	/**
	 * Removes the user info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = findByUUID_G(uuid, groupId);

		return remove(userInfo);
	}

	/**
	 * Returns the number of user infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "userInfo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "userInfo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(userInfo.uuid IS NULL OR userInfo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "userInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			UserInfoModelImpl.UUID_COLUMN_BITMASK |
			UserInfoModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<UserInfo> list = (List<UserInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserInfo userInfo : list) {
				if (!Validator.equals(uuid, userInfo.getUuid()) ||
						(companyId != userInfo.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserInfo>(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public UserInfo findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserInfo> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public UserInfo findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public UserInfo[] findByUuid_C_PrevAndNext(String code, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = findByPrimaryKey(code);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, userInfo, uuid,
					companyId, orderByComparator, true);

			array[1] = userInfo;

			array[2] = getByUuid_C_PrevAndNext(session, userInfo, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserInfo getByUuid_C_PrevAndNext(Session session,
		UserInfo userInfo, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (UserInfo userInfo : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userInfo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userInfo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userInfo.uuid IS NULL OR userInfo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userInfo.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCODE = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserCode",
			new String[] { String.class.getName() },
			UserInfoModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERCODE = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user infos where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserInfo> findByuserCode(String code) throws SystemException {
		return findByuserCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByuserCode(String code, int start, int end)
		throws SystemException {
		return findByuserCode(code, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByuserCode(String code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<UserInfo> list = (List<UserInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserInfo userInfo : list) {
				if (!Validator.equals(code, userInfo.getCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_USERCODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERCODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_USERCODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserInfo>(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user info in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByuserCode_First(String code,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByuserCode_First(code, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByuserCode_First(String code,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserInfo> list = findByuserCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByuserCode_Last(String code,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByuserCode_Last(code, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("code=");
		msg.append(code);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByuserCode_Last(String code,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserCode(code);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByuserCode(code, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the user infos where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserCode(String code) throws SystemException {
		for (UserInfo userInfo : findByuserCode(code, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERCODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_USERCODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERCODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_USERCODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERCODE_CODE_1 = "userInfo.code IS NULL";
	private static final String _FINDER_COLUMN_USERCODE_CODE_2 = "userInfo.code = ?";
	private static final String _FINDER_COLUMN_USERCODE_CODE_3 = "(userInfo.code IS NULL OR userInfo.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] { Long.class.getName() },
			UserInfoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserInfo> findBygroupId(long groupId) throws SystemException {
		return findBygroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findBygroupId(long groupId, int start, int end)
		throws SystemException {
		return findBygroupId(groupId, start, end, null);
	}

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
	@Override
	public List<UserInfo> findBygroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<UserInfo> list = (List<UserInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserInfo userInfo : list) {
				if ((groupId != userInfo.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserInfo>(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findBygroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchBygroupId_First(groupId, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchBygroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserInfo> list = findBygroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findBygroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchBygroupId_Last(groupId, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchBygroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBygroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findBygroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public UserInfo[] findBygroupId_PrevAndNext(String code, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = findByPrimaryKey(code);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getBygroupId_PrevAndNext(session, userInfo, groupId,
					orderByComparator, true);

			array[1] = userInfo;

			array[2] = getBygroupId_PrevAndNext(session, userInfo, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserInfo getBygroupId_PrevAndNext(Session session,
		UserInfo userInfo, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBygroupId(long groupId) throws SystemException {
		for (UserInfo userInfo : findBygroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBygroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "userInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] { Long.class.getName() },
			UserInfoModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user info where userId = &#63; or throws a {@link com.liferay.adduser.NoSuchUserInfoException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByuserId(long userId)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByuserId(userId);

		if (userInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserInfoException(msg.toString());
		}

		return userInfo;
	}

	/**
	 * Returns the user info where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByuserId(long userId) throws SystemException {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the user info where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByuserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof UserInfo) {
			UserInfo userInfo = (UserInfo)result;

			if ((userId != userInfo.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERINFO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<UserInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserInfoPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserInfo userInfo = list.get(0);

					result = userInfo;

					cacheResult(userInfo);

					if ((userInfo.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserInfo)result;
		}
	}

	/**
	 * Removes the user info where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo removeByuserId(long userId)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = findByuserId(userId);

		return remove(userInfo);
	}

	/**
	 * Returns the number of user infos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userInfo.userId = ?";

	public UserInfoPersistenceImpl() {
		setModelClass(UserInfo.class);
	}

	/**
	 * Caches the user info in the entity cache if it is enabled.
	 *
	 * @param userInfo the user info
	 */
	@Override
	public void cacheResult(UserInfo userInfo) {
		EntityCacheUtil.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoImpl.class, userInfo.getPrimaryKey(), userInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { userInfo.getUuid(), userInfo.getGroupId() }, userInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { userInfo.getUserId() }, userInfo);

		userInfo.resetOriginalValues();
	}

	/**
	 * Caches the user infos in the entity cache if it is enabled.
	 *
	 * @param userInfos the user infos
	 */
	@Override
	public void cacheResult(List<UserInfo> userInfos) {
		for (UserInfo userInfo : userInfos) {
			if (EntityCacheUtil.getResult(
						UserInfoModelImpl.ENTITY_CACHE_ENABLED,
						UserInfoImpl.class, userInfo.getPrimaryKey()) == null) {
				cacheResult(userInfo);
			}
			else {
				userInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserInfo userInfo) {
		EntityCacheUtil.removeResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoImpl.class, userInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userInfo);
	}

	@Override
	public void clearCache(List<UserInfo> userInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserInfo userInfo : userInfos) {
			EntityCacheUtil.removeResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
				UserInfoImpl.class, userInfo.getPrimaryKey());

			clearUniqueFindersCache(userInfo);
		}
	}

	protected void cacheUniqueFindersCache(UserInfo userInfo) {
		if (userInfo.isNew()) {
			Object[] args = new Object[] {
					userInfo.getUuid(), userInfo.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				userInfo);

			args = new Object[] { userInfo.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				userInfo);
		}
		else {
			UserInfoModelImpl userInfoModelImpl = (UserInfoModelImpl)userInfo;

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfo.getUuid(), userInfo.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					userInfo);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userInfo.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					userInfo);
			}
		}
	}

	protected void clearUniqueFindersCache(UserInfo userInfo) {
		UserInfoModelImpl userInfoModelImpl = (UserInfoModelImpl)userInfo;

		Object[] args = new Object[] { userInfo.getUuid(), userInfo.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((userInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					userInfoModelImpl.getOriginalUuid(),
					userInfoModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { userInfo.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((userInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { userInfoModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new user info with the primary key. Does not add the user info to the database.
	 *
	 * @param code the primary key for the new user info
	 * @return the new user info
	 */
	@Override
	public UserInfo create(String code) {
		UserInfo userInfo = new UserInfoImpl();

		userInfo.setNew(true);
		userInfo.setPrimaryKey(code);

		String uuid = PortalUUIDUtil.generate();

		userInfo.setUuid(uuid);

		return userInfo;
	}

	/**
	 * Removes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param code the primary key of the user info
	 * @return the user info that was removed
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo remove(String code)
		throws NoSuchUserInfoException, SystemException {
		return remove((Serializable)code);
	}

	/**
	 * Removes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user info
	 * @return the user info that was removed
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo remove(Serializable primaryKey)
		throws NoSuchUserInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserInfo userInfo = (UserInfo)session.get(UserInfoImpl.class,
					primaryKey);

			if (userInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userInfo);
		}
		catch (NoSuchUserInfoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserInfo removeImpl(UserInfo userInfo) throws SystemException {
		userInfo = toUnwrappedModel(userInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userInfo)) {
				userInfo = (UserInfo)session.get(UserInfoImpl.class,
						userInfo.getPrimaryKeyObj());
			}

			if (userInfo != null) {
				session.delete(userInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userInfo != null) {
			clearCache(userInfo);
		}

		return userInfo;
	}

	@Override
	public UserInfo updateImpl(com.liferay.adduser.model.UserInfo userInfo)
		throws SystemException {
		userInfo = toUnwrappedModel(userInfo);

		boolean isNew = userInfo.isNew();

		UserInfoModelImpl userInfoModelImpl = (UserInfoModelImpl)userInfo;

		if (Validator.isNull(userInfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userInfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (userInfo.isNew()) {
				session.save(userInfo);

				userInfo.setNew(false);
			}
			else {
				session.merge(userInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userInfoModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userInfoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfoModelImpl.getOriginalUuid(),
						userInfoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						userInfoModelImpl.getUuid(),
						userInfoModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userInfoModelImpl.getOriginalCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE,
					args);

				args = new Object[] { userInfoModelImpl.getCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE,
					args);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { userInfoModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoImpl.class, userInfo.getPrimaryKey(), userInfo);

		clearUniqueFindersCache(userInfo);
		cacheUniqueFindersCache(userInfo);

		return userInfo;
	}

	protected UserInfo toUnwrappedModel(UserInfo userInfo) {
		if (userInfo instanceof UserInfoImpl) {
			return userInfo;
		}

		UserInfoImpl userInfoImpl = new UserInfoImpl();

		userInfoImpl.setNew(userInfo.isNew());
		userInfoImpl.setPrimaryKey(userInfo.getPrimaryKey());

		userInfoImpl.setUuid(userInfo.getUuid());
		userInfoImpl.setGroupId(userInfo.getGroupId());
		userInfoImpl.setCompanyId(userInfo.getCompanyId());
		userInfoImpl.setCreatorId(userInfo.getCreatorId());
		userInfoImpl.setCreateDate(userInfo.getCreateDate());
		userInfoImpl.setModifiedDate(userInfo.getModifiedDate());
		userInfoImpl.setUserId(userInfo.getUserId());
		userInfoImpl.setCode(userInfo.getCode());
		userInfoImpl.setUsername(userInfo.getUsername());
		userInfoImpl.setEmail(userInfo.getEmail());
		userInfoImpl.setPhone(userInfo.getPhone());

		return userInfoImpl;
	}

	/**
	 * Returns the user info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user info
	 * @return the user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserInfoException, SystemException {
		UserInfo userInfo = fetchByPrimaryKey(primaryKey);

		if (userInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userInfo;
	}

	/**
	 * Returns the user info with the primary key or throws a {@link com.liferay.adduser.NoSuchUserInfoException} if it could not be found.
	 *
	 * @param code the primary key of the user info
	 * @return the user info
	 * @throws com.liferay.adduser.NoSuchUserInfoException if a user info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo findByPrimaryKey(String code)
		throws NoSuchUserInfoException, SystemException {
		return findByPrimaryKey((Serializable)code);
	}

	/**
	 * Returns the user info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user info
	 * @return the user info, or <code>null</code> if a user info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserInfo userInfo = (UserInfo)EntityCacheUtil.getResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
				UserInfoImpl.class, primaryKey);

		if (userInfo == _nullUserInfo) {
			return null;
		}

		if (userInfo == null) {
			Session session = null;

			try {
				session = openSession();

				userInfo = (UserInfo)session.get(UserInfoImpl.class, primaryKey);

				if (userInfo != null) {
					cacheResult(userInfo);
				}
				else {
					EntityCacheUtil.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
						UserInfoImpl.class, primaryKey, _nullUserInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
					UserInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userInfo;
	}

	/**
	 * Returns the user info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param code the primary key of the user info
	 * @return the user info, or <code>null</code> if a user info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserInfo fetchByPrimaryKey(String code) throws SystemException {
		return fetchByPrimaryKey((Serializable)code);
	}

	/**
	 * Returns all the user infos.
	 *
	 * @return the user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<UserInfo> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<UserInfo> list = (List<UserInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERINFO;

				if (pagination) {
					sql = sql.concat(UserInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserInfo>(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserInfo userInfo : findAll()) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos.
	 *
	 * @return the number of user infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERINFO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the user info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.adduser.model.UserInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserInfo>> listenersList = new ArrayList<ModelListener<UserInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserInfo>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UserInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERINFO = "SELECT userInfo FROM UserInfo userInfo";
	private static final String _SQL_SELECT_USERINFO_WHERE = "SELECT userInfo FROM UserInfo userInfo WHERE ";
	private static final String _SQL_COUNT_USERINFO = "SELECT COUNT(userInfo) FROM UserInfo userInfo";
	private static final String _SQL_COUNT_USERINFO_WHERE = "SELECT COUNT(userInfo) FROM UserInfo userInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static UserInfo _nullUserInfo = new UserInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserInfo> toCacheModel() {
				return _nullUserInfoCacheModel;
			}
		};

	private static CacheModel<UserInfo> _nullUserInfoCacheModel = new CacheModel<UserInfo>() {
			@Override
			public UserInfo toEntityModel() {
				return _nullUserInfo;
			}
		};
}