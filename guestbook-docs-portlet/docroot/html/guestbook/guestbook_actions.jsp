<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Entry entry = (Entry) row.getObject();
%>

<<<<<<< HEAD
<c:if
	test="<%=EntryPermission.contains(permissionChecker,
						entry.getEntryId(), ActionKeys.UPDATE)%>">
	<portlet:renderURL var="editURL">
		<portlet:param name="entryId"
			value="<%=String.valueOf(entry.getEntryId())%>" />
		<portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" message="Edit"
		url="<%=editURL.toString()%>" />
</c:if>

<c:if
	test="<%=EntryPermission.contains(permissionChecker,
						entry.getEntryId(), ActionKeys.PERMISSIONS)%>">

	<liferay-security:permissionsURL
		modelResource="<%=Entry.class.getName()%>"
		modelResourceDescription="<%=entry.getMessage()%>"
		resourcePrimKey="<%=String.valueOf(entry.getEntryId())%>"
		var="permissionsURL" />

	<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />

</c:if>

<c:if
	test="<%=EntryPermission.contains(permissionChecker,
						entry.getEntryId(), ActionKeys.DELETE)%>">

	<portlet:actionURL name="deleteEntry" var="deleteURL">
		<portlet:param name="entryId"
			value="<%=String.valueOf(entry.getEntryId())%>" />
		<portlet:param name="guestbookId"
			value="<%=String.valueOf(entry.getGuestbookId())%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
</c:if>
=======
<liferay-ui:icon-menu>

	<c:if
		test="<%=EntryPermission.contains(permissionChecker,
							entry.getEntryId(), ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="entryId"
				value="<%=String.valueOf(entry.getEntryId())%>" />
			<portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>

	<c:if
		test="<%=EntryPermission.contains(permissionChecker,
							entry.getEntryId(), ActionKeys.PERMISSIONS)%>">

		<liferay-security:permissionsURL
			modelResource="<%=Entry.class.getName()%>"
			modelResourceDescription="<%=entry.getMessage()%>"
			resourcePrimKey="<%=String.valueOf(entry.getEntryId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />

	</c:if>

	<c:if
		test="<%=EntryPermission.contains(permissionChecker,
							entry.getEntryId(), ActionKeys.DELETE)%>">

		<portlet:actionURL name="deleteEntry" var="deleteURL">
			<portlet:param name="entryId"
				value="<%=String.valueOf(entry.getEntryId())%>" />
			<portlet:param name="guestbookId"
				value="<%=String.valueOf(entry.getGuestbookId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>

</liferay-ui:icon-menu>
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
