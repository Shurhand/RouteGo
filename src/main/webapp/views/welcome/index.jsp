<%--
 * index.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<p>
	<spring:message code="welcome.greeting.prefix" />
	${name}
	<spring:message code="welcome.greeting.suffix" />
</p>

<p>
	<spring:message code="welcome.greeting.current.time" />
	${moment}
</p>

<a href="/RouteGo/route/create.do" id="button-1" data-rel="external" class="ui-btn ui-icon-arrow-d-l ui-btn-icon-left ui-btn-inline ui-corner-all ui-btn-a">Create Route</a>
