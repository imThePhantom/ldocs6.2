package com.liferay.docs.guestbook.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GuestbookAdminPortlet
 */
public class GuestbookAdminPortlet extends MVCPortlet {

	public void addGuestbook(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Guestbook.class.getName(), actionRequest);
		String name = ParamUtil.getString(actionRequest, "name");

		try {
			GuestbookLocalServiceUtil.addGuestbook(serviceContext.getUserId(),
					name, serviceContext);
			SessionMessages.add(actionRequest, "Guestbook Added");

		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass(), e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/guestbookadmin/edit_guestbook.jsp");
		}
	}

	public void updateGuestbook(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Guestbook.class.getName(), actionRequest);
		String name = ParamUtil.getString(actionRequest, "name");
		long guestbookId = ParamUtil.getLong(actionRequest, "guestbookId");

		try {
			GuestbookLocalServiceUtil.updateGuestbook(
					serviceContext.getUserId(), guestbookId, name,
					serviceContext);

			SessionMessages.add(actionRequest, "Guestbook Updated");
		} catch (PortalException pe) {
			SessionErrors.add(actionRequest, pe.getClass(), pe);

			actionResponse.setRenderParameter("mvcPath",
					"/html/guestbookadmin/edit_guestbook.jsp");
		}
	}

	public void deleteGuestbook(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Guestbook.class.getName(), actionRequest);

		long guestbookId = ParamUtil.getLong(actionRequest, "guestbookId");
		try {
			GuestbookLocalServiceUtil.deleteGuestbook(guestbookId,
					serviceContext);

			SessionMessages.add(actionRequest, "Guestbook Deleted");
		} catch (PortalException pe) {
			SessionErrors.add(actionRequest, pe.getClass(), pe);
		}
	}
}
