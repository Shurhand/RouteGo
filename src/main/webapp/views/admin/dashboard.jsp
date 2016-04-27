<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<br><br><br><br><br><br><br>
<div class="container-fluid">
<h3><spring:message code="dashboard.customers"/></h3>
<div class="table-responsive">
<display:table name="customers" id="row" requestURI="${requestURI}"
	pagesize="5" class="table table-hover">
	
	<spring:message code="dashboard.actor.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="dashboard.actor.surname" var="surnameHeader"/>
	<display:column property="surname" title="${surnameHeader}" sortable="true"/>
	
	<spring:message code="dashboard.actor.email" var="emailHeader"/>
	<display:column property="email" title="${emailHeader}" sortable="false"/>
	
	<spring:message code="dashboard.actor.phone" var="phoneHeader"/>
	<display:column property="phone" title="${phoneHeader}" sortable="false"/>
	
	<spring:message code="dashboard.actor.postalAddress" var="postalAddressHeader"/>
	<display:column property="postalAddress" title="${postalAddressHeader}" sortable="false"/>
		

</display:table>
</div>

<h3><spring:message code="dashboard.companies"/></h3>
<div class="table-responsive">
<display:table name="companies" id="row" requestURI="${requestURI}"
	pagesize="5" class="table table-hover">
	
	<spring:message code="dashboard.actor.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="dashboard.actor.surname" var="surnameHeader"/>
	<display:column property="surname" title="${surnameHeader}" sortable="true"/>
	
	<spring:message code="dashboard.actor.email" var="emailHeader"/>
	<display:column property="email" title="${emailHeader}" sortable="false"/>
	
	<spring:message code="dashboard.actor.phone" var="phoneHeader"/>
	<display:column property="phone" title="${phoneHeader}" sortable="false"/>
	
	<spring:message code="dashboard.actor.postalAddress" var="postalAddressHeader"/>
	<display:column property="postalAddress" title="${postalAddressHeader}" sortable="false"/>
		

</display:table>
</div>

<h3><spring:message code="dashboard.activities"/></h3>
<div class="table-responsive">
<display:table name="activities" id="row" requestURI="${requestURI}"
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
	
	<spring:message code="activity.duration" var="durationHeader"/>
	<display:column property="duration" title="${durationHeader}" sortable="false"/>
	
	<spring:message code="activity.startingDate" var="startingDateHeader"/>
	<display:column property="startingDate" title="${startingDateHeader}" sortable="false"/>
	
	<spring:message code="activity.endingDate" var="endingDateHeader"/>
	<display:column property="endingDate" title="${endingDateHeader}" sortable="false"/>
		

</display:table>
</div>

</div>