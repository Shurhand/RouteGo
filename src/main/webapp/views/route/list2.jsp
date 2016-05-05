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
<display:table name="routes" id="row" requestURI="route/customer/list2.do"
	pagesize="5" class="table table-hover">
	
	<spring:message code="route.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="route.description" var="descriptionHeader"/>
	<display:column property="description" title="${descriptionHeader}" sortable="false"/>
	
	<fmt:formatDate var="startingDate" value="${row.startingDate}" pattern="dd/MM/yyyy" />
	
	<spring:message code="route.startingDate" var="startingDateHeader"/>
	<display:column value="${startingDate}" title="${startingDateHeader}" sortable="false"/>
	
	<fmt:formatDate var="endDate" value="${row.endDate}" pattern="dd/MM/yyyy" />
	
	<spring:message code="route.endDate" var="endingDateHeader"/>
	<display:column value="${endDate}" title="${endingDateHeader}" sortable="false"/>
	
	<spring:message code="route.display" var="displayHeader"/>
	<display:column title="${displayHeader}" sortable="false">
					
		<a href="route/customer/display.do?routeID=${row.id}"><spring:message code="route.display" /> </a>
	
	</display:column>

</display:table>
	
<br>

</div>
</div>