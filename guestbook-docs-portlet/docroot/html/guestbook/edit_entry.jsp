<%@include file="/html/init.jsp"%>

<%
	long entryId = ParamUtil.getLong(renderRequest, "entryId");

	Entry entry = null;

	if (entryId > 0) {

		entry = EntryLocalServiceUtil.getEntry(entryId);

	}

	Guestbook guestbook = (Guestbook) renderRequest.getAttribute(WebKeys.GUESTBOOK);
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view.jsp"></portlet:param>
	<portlet:param name="guestbookName" value="<%= guestbook.getName() %>"/>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL">
	<portlet:param name="guestbookName" value="<%= guestbook.getName() %>"/>
</portlet:actionURL>

<aui:form action="<%=addEntryURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%=entry%>" model="<%=Entry.class%>" />

	<aui:fieldset>
		<aui:input name="entryId" type="hidden" />
		<aui:input name='guestbookId' type='hidden' 
			value='<%= String.valueOf(guestbook.getGuestbookId()) %>'/>
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="email">
			<aui:validator name="email" />
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="message">
			<aui:validator name="required" />
		</aui:input>
		<div id="counterContainer">
			<p>
				<span id="counter"></span> character (s) remaining
			</p>
		</div>

		<aui:input name='guestbookId' type='hidden'
			value='<%=ParamUtil.getString(renderRequest, "guestbookId")%>' />

	</aui:fieldset>

	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryCategorizationPanel" persistState="<%=true%>"
		title="categorization">
		<aui:fieldset>
			<aui:input name="categories" type="assetCategories" />

			<aui:input name="tags" type="assetTags" />
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryAssetLinksPanel" persistState="<%=true%>"
		title="related-assets">
		<aui:fieldset>
			<liferay-ui:input-asset-links className="<%=Entry.class.getName()%>"
				classPK="<%=entryId%>" ></liferay-ui:input-asset-links>
		</aui:fieldset>
	</liferay-ui:panel>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

	</aui:button-row>
</aui:form>

<aui:script use="aui-char-counter">
AUI().use(
		function(A){
			new A.CharCounter(
			{
				counter: '#counter',
				input: '#<portlet:namespace/>message',
				maxLength: 500
			}
		);
	}
);
</aui:script>