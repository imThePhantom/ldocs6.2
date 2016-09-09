package com.liferay.adduser;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.adduser.model.UserInfo;
import com.liferay.adduser.service.UserInfoLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AddUser
 */
public class AddUser extends MVCPortlet {

	public void addUser(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				UserInfo.class.getName(), request);
		String code = ParamUtil.getString(request, "code");
		String username = ParamUtil.getString(request, "firstname");
		String email = ParamUtil.getString(request, "email");
		String phone = ParamUtil.getString(request, "phone");

		try {
			UserInfoLocalServiceUtil.addUserInfo(code, username, email, phone,
					serviceContext);
			SessionMessages.add(request, "UserAdded");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath",
					"/html/adduser/add_user.jsp");
		}
	}
}
