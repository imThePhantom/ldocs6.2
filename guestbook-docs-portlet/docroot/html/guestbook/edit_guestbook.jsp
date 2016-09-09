<%@include file="/html/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addGuestbook" var="addGuestbookURL"></portlet:actionURL>
<<<<<<< HEAD
<liferay-ui:error key="existing-guestbook" message="existing-guestbook" />
=======
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565

<aui:form action="<%=addGuestbookURL%>" name="<portlet:namespace />fm">

	<aui:fieldset>

<<<<<<< HEAD
		<aui:input name="guestbookName" label="Guestbook Name"/>
=======
		<aui:input name="name" />
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>

	</aui:button-row>
</aui:form>