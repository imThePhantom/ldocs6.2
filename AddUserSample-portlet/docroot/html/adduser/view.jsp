<%@include file="/html/init.jsp"%>

This is the <b>Add User</b> sample portlet.

<portlet:renderURL var="addUserURL">
	<portlet:param name="mvcPath" value="/html/adduser/add_user.jsp" />
</portlet:renderURL>

<aui:button onClick="<%= addUserURL.toString()%>" name="Add User" value="Add User"></aui:button>