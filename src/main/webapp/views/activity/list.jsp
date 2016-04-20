<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date" />

<br><br><br><br><br><br><br>
<div class="container-fluid">
<div class="table-responsive">
<display:table name="activities" id="row" requestURI="activity/list.do"
	pagesize="5" class="table table-hover">
	
	<spring:message code="activity.picture" var="pictureHeader"/>
	<display:column><center><img src="${row.picture }" alt="${row.name }" height="80" ></center>
	</display:column>
	
	<spring:message code="activity.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="activity.description" var="descriptionHeader"/>
	<display:column property="description" title="${descriptionHeader}" sortable="false"/>
	
	<spring:message code="activity.cost" var="costHeader"/>
	<display:column value="${row.cost} Euros" title="${costHeader}" sortable="false"/>
	
	<spring:message code="activity.postalAddress" var="postalAddressHeader"/>
	<display:column property="postalAddress" title="${postalAddressHeader}" sortable="false"/>
	<!--  
	<spring:message code="activity.latitude" var="latitudeHeader"/>
	<display:column property="latitude" title="${latitudeHeader}" sortable="false"/>
	
	<spring:message code="activity.longitude" var="longitudeHeader"/>
	<display:column property="longitude" title="${longitudeHeader}" sortable="false"/>
	-->
	
	<spring:message code="activity.duration" var="durationHeader"/>
	<display:column property="duration" title="${durationHeader}" sortable="false"/>
	
	<spring:message code="activity.startingDate" var="startingDateHeader"/>
	<display:column property="startingDate" title="${startingDateHeader}" sortable="false"/>
	
	<spring:message code="activity.endingDate" var="endingDateHeader"/>
	<display:column property="endingDate" title="${endingDateDateHeader}" sortable="false"/>
	
	 
	
	<display:column> <a href="activity/edit.do?activityId=<jstl:out value="${row.id}"/>"><spring:message code="activity.edit"/></a></display:column>
	<display:column> <a href="activity/deleteCategory.do?activityId=<jstl:out value="${row.id}"/>"><spring:message code="activity.delete"/></a></display:column>
	
</display:table>
</div>
<br>
	<div>
		<a href="activity/create.do"> <spring:message
				code="activity.create" />
		</a>
	</div>

</div>

