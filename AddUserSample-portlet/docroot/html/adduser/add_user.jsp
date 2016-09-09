<%@include file="/html/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/adduser/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addUser" var="addUserURL">
</portlet:actionURL>

<aui:form action="<%=addUserURL%>" name="<portlet:namespace />fm">
	<aui:fieldset>
		<aui:input name="code">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
		</aui:input>
		<aui:input name="firstname" inlineField="true">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="midlename" inlineField="true" />
		<aui:input name="lastname" />
		<aui:input name="email">
			<aui:validator name="email" />
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="phone">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

	</aui:button-row>
</aui:form>