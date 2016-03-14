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

<form:form action="company/admin/edit.do" modelAttribute="company">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="userAccount.authorities" />
	

	<form:label path="name">
		<spring:message code="company.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br></br>
	
	<form:label path="surname">
		<spring:message code="company.surname" />:
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br></br>
	
	<form:label path="email">
		<spring:message code="company.email" />:
	</form:label>
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br></br>
	
	<form:label path="phone">
		<spring:message code="company.phoneNumber" />:
	</form:label>
	<form:input path="phone" />
	<form:errors cssClass="error" path="phone" />
	<br></br>
	
	<form:label path="postalAddress">
		<spring:message code="company.address" />:
	</form:label>
	<form:input path="postalAddress" />
	<form:errors cssClass="error" path="postalAddress" />
	<br></br>
	
	<form:label path="picture">
		<spring:message code="company.picture" />:
	</form:label>
	<form:input path="picture" />
	<form:errors cssClass="error" path="picture" />
	<br></br>
	
	<form:label path="CIF">
		<spring:message code="company.CIF" />:
	</form:label>
	<form:input path="CIF" />
	<form:errors cssClass="error" path="CIF" />
	<br></br>
	
	<form:label path="userAccount.username">
		<spring:message code="company.username" />:  
	</form:label>
	<form:input path="userAccount.username" />
	<form:errors cssClass="error" path="userAccount.username" />
	<br></br>

	<form:label path="userAccount.password">
		<spring:message code="company.password" />:  
	</form:label>
	<form:password path="userAccount.password" />
	<form:errors cssClass="error" path="userAccount.password" />
	<br></br>

	<input type="submit" name="save"
		value="<spring:message code="company.register" />" />
		&nbsp;
		
	<input type="button" name="cancel"
		value="<spring:message code="company.cancel" />"
		onclick="javascript: window.location.replace('security/login.do');" /> 
		
		
		
		


</form:form>