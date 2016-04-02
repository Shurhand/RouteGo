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
<spring:message code="activity.create" />
</h2>

<form:form action="activity/edit.do" modelAttribute="activity" class="form-horizontal">
 <br>
  
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="schedules" />
	<form:hidden path="company" />
	<form:hidden path="route" />
	
	
  <div class='col-md-6'>
	<div class="form-group" >
	
	<form:label path="name" class="col-sm-5 control-label">
		<spring:message code="activity.name" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="name" class="form-control" />
	<form:errors cssClass="error" path="name" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="description" class="col-sm-5 control-label">
		<spring:message code="activity.description" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:textarea path="description" class="form-control" />
	<form:errors cssClass="error" path="description" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="cost" class="col-sm-5 control-label">
		<spring:message code="activity.cost" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="cost" class="form-control" />
	<form:errors cssClass="error" path="cost" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="postalAddress" class="col-sm-5 control-label">
		<spring:message code="activity.postalAddress" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="postalAddress" class="form-control" />
	<form:errors cssClass="error" path="postalAddress" />
		</div>
	</div>
	
	
	<div class="form-group" >
	
	<form:label path="latitude" class="col-sm-5 control-label">
		<spring:message code="activity.latitude" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="latitude" class="form-control" />
	<form:errors cssClass="error" path="latitude" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="longitude" class="col-sm-5 control-label">
		<spring:message code="activity.longitude" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="longitude" class="form-control" />
	<form:errors cssClass="error" path="longitude" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="picture" class="col-sm-5 control-label">
		<spring:message code="activity.picture" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="picture" class="form-control" />
	<form:errors cssClass="error" path="picture" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="duration" class="col-sm-5 control-label">
		<spring:message code="activity.duration" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="duration" class="form-control" />
	<form:errors cssClass="error" path="duration" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="startingDate" class="col-sm-5 control-label">
		<spring:message code="activity.startingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="startingDate" class="form-control" />
	<form:errors cssClass="error" path="startingDate" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="endingDate" class="col-sm-5 control-label">
		<spring:message code="activity.endingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="endingDate" class="form-control" />
	<form:errors cssClass="error" path="endingDate" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label  path="categories" class="col-sm-5 control-label">
		<spring:message code="activity.categories" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select multiple="true" path="categories" class="form-control">
		<form:option value="0">----</form:option>
		<form:options
			items="${categories}"
			itemLabel="name"
			itemValue="id"
		/>
	</form:select>
	<form:errors cssClass="error" path="categories" />
		</div>
	</div>
		
  </div>
<br>



<div class="form-group">
<div class="col-xs-4"></div>

	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="activity.save" />" />
		&nbsp;
		
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="activity.cancel" />"
		onclick="javascript: window.location.replace('security/login.do');" /> 
	
	</div>
</form:form>
</div>
</div>