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
<display:table name="schedules" id="row" requestURI="${requestURI}"
	pagesize="7" class="table table-hover">
		
	<spring:message code="schedule.dayOfWeek" var="dayOfWeekHeader"/>
	<display:column property="dayOfWeek" title="${dayOfWeekHeader}" sortable="true"/>
	
	<spring:message code="schedule.openingDate" var="openingDateHeader"/>
	<display:column property="openingDate" title="${openingDateHeader}" sortable="false"/>
	
	<spring:message code="schedule.closingDate" var="closingDateHeader"/>
	<display:column property="closingDate" title="${closingDateHeader}" sortable="false"/>
	
		
	<display:column> 
	<jstl:if test="${row.activity.company == null || row.activity.company.id == principalId}">
	<a href="schedule/edit.do?scheduleId=<jstl:out value="${row.id}"/>"><spring:message code="schedule.edit"/></a>
	</jstl:if>
	</display:column>
	
</display:table>
</div>
<br>
	<div>
		<a href="schedule/create.do"> <spring:message
				code="schedule.create" />
		</a>
	</div>

</div>

