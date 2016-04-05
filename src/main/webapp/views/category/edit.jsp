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
<spring:message code="category.create" />
</h2>

<form:form action="category/admin/edit.do" modelAttribute="category" class="form-horizontal">
 <br>
  
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="activities" />
	<form:hidden path="route" />
	
	
  <div class='col-md-6'>
	<div class="form-group" >
	
	<form:label path="name" class="col-sm-5 control-label">
		<spring:message code="category.name" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="name" class="form-control" />
	<form:errors cssClass="error" path="name" />
		</div>
	</div>
		
  </div>
<br>


<div class="form-group">
<div class="col-xs-4"></div>

	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="category.save" />" />
		&nbsp;
		
	<jstl:if test="${category.id != 0}">
		<input type="submit" name="delete" class="btn btn-primary"
			value="<spring:message code="category.delete"/>"
			onclick="return confirm('<spring:message code="category.confirm.delete" />')" />
		&nbsp
	</jstl:if>
	
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="category.cancel" />"
		onclick="javascript: window.location.replace('security/login.do');" /> 
	
	</div>
</form:form>
</div>
</div>