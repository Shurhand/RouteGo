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

<form:form action="route/create.do" modelAttribute="tripForm">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="startingDate">
		<spring:message code="route.startingDate" />:
	</form:label>
	<form:input path="startingDate" />
	<form:errors cssClass="error" path="startingDate" />
	<br />
	
	<form:label path="endDate">
		<spring:message code="route.endDate" />:
	</form:label>
	<form:input path="endDate" />
	<form:errors cssClass="error" path="endDate" />
	<br />
	
	<form:label path="cost">
		<spring:message code="route.cost" />:
	</form:label>
	<form:input path="cost" />
	<form:errors cssClass="error" path="cost" />
	<br/>

	<form:label path="checkCulturalCategory">
		<spring:message code="route.checkCultural" />
	</form:label>
	<form:checkbox path="checkCulturalCategory"/>
	<form:errors class="error" path="checkCulturalCategory" />
	<br />
	
	<form:label path="checkMuseumsCategory">
		<spring:message code="route.checkMuseums" />
		</form:label>
	<form:checkbox path="checkMuseumsCategory"/>
	<form:errors class="error" path="checkMuseumsCategory" />
	<br />
	
	<form:label path="checkRestaurantsCategory">
		<spring:message code="route.checkRestaurants" />
	</form:label>
	<form:checkbox path="checkRestaurantsCategory"/>
	<form:errors class="error" path="checkRestaurantsCategory" />
	<br />
	
	<form:label path="checkChurchesCategory">
		<spring:message code="route.checkChurches" />
	</form:label>
	<form:checkbox path="checkChurchesCategory"/>
	<form:errors class="error" path="checkChurchesCategory" />
	<br />


	<input type="submit" name="create"
		value="<spring:message code="route.createTrip" />" />&nbsp; 


</form:form>