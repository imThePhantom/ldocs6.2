package com.liferay.docs.guestbook.portlet;

import java.io.IOException;
<<<<<<< HEAD
=======

>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
<<<<<<< HEAD
=======

>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.EntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;
<<<<<<< HEAD
import com.liferay.docs.guestbook.util.WebKeys;
=======
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
<<<<<<< HEAD
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
=======
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GuestbookPortlet
 */
public class GuestbookPortlet extends MVCPortlet {

	public void addEntry(ActionRequest request, ActionResponse response)
<<<<<<< HEAD
		       throws PortalException, SystemException {

		    ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Entry.class.getName(), request);

		    String userName = ParamUtil.getString(request, "name");
		    String email = ParamUtil.getString(request, "email");
		    String message = ParamUtil.getString(request, "message");
		    String guestbookName = ParamUtil.getString(request, "guestbookName");
		    long entryId = ParamUtil.getLong(request, "entryId");

		    OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil.getOrderByComparatorFactory();
		    OrderByComparator orderByComparator = orderByComparatorFactory.create("guestbook", "name", true);

		    Guestbook guestbook = GuestbookLocalServiceUtil.getGuestbookByG_N(
		         serviceContext.getScopeGroupId(), guestbookName,
		         orderByComparator);

		    if (entryId > 0) {
		       try {
		         EntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
		              guestbook.getGuestbookId(), entryId, userName, email, message,
		              serviceContext);

		         SessionMessages.add(request, "entryAdded");

		         response.setRenderParameter("guestbookName",
		              guestbookName);
		       } catch (Exception e) {
		         SessionErrors.add(request, e.getClass().getName());

		         PortalUtil.copyRequestParameters(request, response);

		         response.setRenderParameter("mvcPath",
		              "/html/guestbook/edit_entry.jsp");
		       }
		    }
		    else {
		       try {
		         EntryLocalServiceUtil.addEntry(serviceContext.getUserId(),
		              guestbook.getGuestbookId(), userName, email, message, serviceContext);

		         SessionMessages.add(request, "entryAdded");

		         response.setRenderParameter("guestbookName",
		              guestbookName);
		       } catch (Exception e) {
		         SessionErrors.add(request, e.getClass().getName());

		         PortalUtil.copyRequestParameters(request, response);

		         response.setRenderParameter("mvcPath",
		              "/html/guestbook/edit_entry.jsp");
		       }
		    }
		}

=======
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Entry.class.getName(), request);

		String userName = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String message = ParamUtil.getString(request, "message");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");
		long entryId = ParamUtil.getLong(request, "entryId");

		if (entryId > 0) {

			try {

				EntryLocalServiceUtil.updateEntry(serviceContext.getUserId(),
						guestbookId, entryId, userName, email, message,
						serviceContext);

				SessionMessages.add(request, "entryAdded");

				response.setRenderParameter("guestbookId",
						Long.toString(guestbookId));

			} catch (Exception e) {

				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/guestbook/edit_entry.jsp");
			}

		} else {

			try {
				EntryLocalServiceUtil.addEntry(serviceContext.getUserId(),
						guestbookId, userName, email, message, serviceContext);

				SessionMessages.add(request, "entryAdded");

				response.setRenderParameter("guestbookId",
						Long.toString(guestbookId));

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/guestbook/edit_entry.jsp");
			}
		}

	}

>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
	public void addGuestbook(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Guestbook.class.getName(), request);
<<<<<<< HEAD
		String name = ParamUtil.getString(request, "guestbookName");
		try {
			GuestbookLocalServiceUtil.addGuestbook(serviceContext.getUserId(),
					name, serviceContext);
			SessionMessages.add(request, "guestbookAdded");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath",
					"/html/guestbook/edit_guestbook.jsp");
		}
	}

	public void deleteEntry(ActionRequest request, ActionResponse response) {

		long entryId = ParamUtil.getLong(request, "entryId");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Entry.class.getName(), request);
			response.setRenderParameter("guestbookId",
					Long.toString(guestbookId));
			EntryLocalServiceUtil.deleteEntry(entryId, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	@Override
	public void render(RenderRequest renderRequest,
	       RenderResponse renderResponse) throws PortletException, IOException {

	    try {
	       Guestbook guestbook = null;
	       
	       ServiceContext serviceContext = ServiceContextFactory.getInstance(
	          Guestbook.class.getName(), renderRequest);
	       
	       String guestbookName = "";
	       
	       long groupId = serviceContext.getScopeGroupId();
	       
	       List<Guestbook> guestbooks = GuestbookLocalServiceUtil
	          .getGuestbooks(groupId);

	       if (guestbooks.size() == 0) {
	         guestbook = GuestbookLocalServiceUtil.addGuestbook(
	              serviceContext.getUserId(), "Main", serviceContext);
	         renderRequest.setAttribute(WebKeys.GUESTBOOK, guestbook);
	       }

	       guestbook = (Guestbook) renderRequest
	          .getAttribute(WebKeys.GUESTBOOK);
	       
	       if (guestbook == null) {
	         guestbookName = ParamUtil.getString(renderRequest,
	              "guestbookName");
				if (guestbookName.equalsIgnoreCase("")) {
	          guestbook = guestbooks.get(0);

	         } else {
	          OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
	                 .getOrderByComparatorFactory();
	          OrderByComparator orderByComparator = orderByComparatorFactory
	                 .create("guestbook", "name", true);

	          guestbook = GuestbookLocalServiceUtil.getGuestbookByG_N(
	                 serviceContext.getScopeGroupId(), guestbookName,
	                 orderByComparator);
	         }
	       }
	       renderRequest.setAttribute(WebKeys.GUESTBOOK, guestbook);
	    } catch (Exception e) {
	       throw new PortletException(e);
	    }
	    super.render(renderRequest, renderResponse);
=======

		String name = ParamUtil.getString(request, "name");

		try {
			GuestbookLocalServiceUtil.addGuestbook(serviceContext.getUserId(),
					name, serviceContext);

			SessionMessages.add(request, "guestbookAdded");

		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			response.setRenderParameter("mvcPath",
					"/html/guestbook/edit_guestbook.jsp");
		}

	}

	public void deleteEntry (ActionRequest request, ActionResponse response) {

	    long entryId = ParamUtil.getLong(request, "entryId");
	    long guestbookId = ParamUtil.getLong(request, "guestbookId");

	    try {

	       ServiceContext serviceContext = ServiceContextFactory.getInstance(
	         Entry.class.getName(), request);

	                    response.setRenderParameter("guestbookId", Long.toString(guestbookId));

	       EntryLocalServiceUtil.deleteEntry(entryId, serviceContext);

	    } catch (Exception e) {

	       SessionErrors.add(request, e.getClass().getName());
	    }
	}
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Guestbook.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();

			long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");

			List<Guestbook> guestbooks = GuestbookLocalServiceUtil
					.getGuestbooks(groupId);

			if (guestbooks.size() == 0) {
				Guestbook guestbook = GuestbookLocalServiceUtil.addGuestbook(
						serviceContext.getUserId(), "Main", serviceContext);

				guestbookId = guestbook.getGuestbookId();

			}

			if (!(guestbookId > 0)) {
				guestbookId = guestbooks.get(0).getGuestbookId();
			}

			renderRequest.setAttribute("guestbookId", guestbookId);

		} catch (Exception e) {

			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);

>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
	}
}
