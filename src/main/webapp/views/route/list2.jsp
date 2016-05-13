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
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
<link href="styles/star-rating.css" media="all" rel="stylesheet" type="text/css" />
<script src="scripts/star-rating.js" type="text/javascript"></script>

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
	
	<spring:message code="route.rateRoute" var="rateRouteHeader"/>
	<display:column title="${rateRouteHeader}" sortable="false">
	<form:form action="route/customer/ratea.do" modelAttribute="route" class="form-horizontal">
	
	<div class="pull-left">
	<input id="input-id" name="rate" type="number" class="rating" min=1 max=5 step=1 data-size="xs" data-rtl="false">
  	</div>
  	<input type="hidden" name="routeId" value="${row.id}">
  	&nbsp &nbsp
  	<input type="submit" name="rate" class="btn btn-primary" value="rate" />
  	</form:form>
  	</display:column>
	
	<spring:message code="route.rating" var="ratingHeader"/>
	<display:column property="rating" title="${ratingHeader}" sortable="true"/>
	
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