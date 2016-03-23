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
  
<h3 class="text-center">
<spring:message code="customer.register" />
</h3>


<form:form action="customer/edit.do" modelAttribute="customer" class="form-horizontal">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="userAccount.authorities" />
	
	<div class="form-group" >
	
	<form:label path="name" class="col-sm-5 control-label">
		<spring:message code="customer.name" />:
	</form:label>
	
	<div class="col-xs-2">
	<form:input path="name" class="form-control" />
	<form:errors cssClass="error" path="name" />
		</div>
	</div>
	
		<div class="form-group">
	

	
	<form:label path="surname" class="col-sm-5 control-label">
		<spring:message code="customer.surname" />:
	</form:label>
	<div class="col-xs-2">
	<form:input path="surname" class="form-control"/>
	<form:errors cssClass="error" path="surname" />
	
		
			</div>
	</div>
		<div class="form-group">
	
	<form:label path="email" class="col-sm-5 control-label">
		<spring:message code="customer.email" />:
	</form:label>
	<div class="col-xs-2">
	<form:input path="email" class="form-control"/>
	<form:errors cssClass="error" path="email" />
			</div>
	</div>
		<div class="form-group">
	
	
	<form:label path="phone" class="col-sm-5 control-label">
		<spring:message code="customer.phoneNumber" />:
	</form:label>
	<div class="col-xs-2">
	<form:input path="phone" class="form-control"/>
	<form:errors cssClass="error" path="phone" />
			</div>
	</div>
		<div class="form-group">
	
	
	<form:label path="postalAddress" class="col-sm-5 control-label">
		<spring:message code="customer.address" />:
	</form:label>
	<div class="col-xs-2">
	<form:input path="postalAddress" class="form-control"/>
	<form:errors cssClass="error" path="postalAddress" />
			</div>
	</div>
	
		<div class="form-group">
	
	<form:label path="picture" class="col-sm-5 control-label">
		<spring:message code="customer.picture" />:
	</form:label>
	<div class="col-xs-2">
	<form:input path="picture" class="form-control"/>
	<form:errors cssClass="error" path="picture" />
			</div>
	</div>
		<div class="form-group">
	
	
	<form:label path="userAccount.username" class="col-sm-5 control-label">
		<spring:message code="customer.username" />:  
	</form:label>
	<div class="col-xs-2">
	<form:input path="userAccount.username" class="form-control" />
	<form:errors cssClass="error" path="userAccount.username" />
			</div>
	</div>
		
	<div class="form-group">

	<form:label path="userAccount.password" class="col-sm-5 control-label">
		<spring:message code="customer.password" />:  
	</form:label>
	<div class="col-xs-2">
	<form:password path="userAccount.password" class="form-control" />
	<form:errors cssClass="error" path="userAccount.password" />
			</div>
</div>

<div class="form-group">
<div class="col-xs-5"></div>

	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="customer.register" />" />
		&nbsp;
		
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="customer.cancel" />"
		onclick="javascript: window.location.replace('security/login.do');" /> 
	
	</div>
</form:form>