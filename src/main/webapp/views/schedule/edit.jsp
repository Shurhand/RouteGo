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
  
  
<div class="container">
  <div class="jumbotron">
  <br><br><br>
<h2 class="text-center">
<spring:message code="schedule.create" />
</h2>

<form:form action="schedule/edit.do" modelAttribute="schedule" class="form-horizontal">
 <br>
  
	<form:hidden path="id" />
	<form:hidden path="version" />
	
	
  <div class='col-md-6'>
	<div class="form-group" >
	
	<form:label path="dayOfWeek" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="dayOfWeek" class="form-control" />
	<form:errors cssClass="error" path="dayOfWeek" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="openingDate" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="openingDate" class="form-control" />
	<form:errors cssClass="error" path="openingDate" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="closingDate" class="form-control" />
	<form:errors cssClass="error" path="closingDate" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label  path="activity" class="col-sm-5 control-label">
		<spring:message code="schedule.activities" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select multiple="true" path="activity" class="form-control">
		<form:option value="0">----</form:option>
		<form:options
			items="${activities}"
			itemLabel="name"
			itemValue="id"
		/>
	</form:select>
	<form:errors cssClass="error" path="activity" />
		</div>
	</div>
		
  </div>
<br>



<div class="form-group">
<div class="col-xs-4"></div>

	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="schedule.save" />" />
		&nbsp;
		
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="schedule.cancel" />"
		onclick="javascript: window.location.replace('/');" /> 
	
	</div>
</form:form>
</div>
</div>