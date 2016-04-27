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

       <script type="text/javascript">
            $(function () {
                $('#datepicker1').datepicker({
           	     format: "dd/mm/yyyy",
           	     clearBtn: true,
           	     startDate: "0",
           	     todayHighlight: true,
           	     daysOfWeekHighlighted: "0",
                })});
       </script>
       
       <script type="text/javascript">
            $(function () {
                $('#datepicker2').datepicker({
           	     format: "dd/mm/yyyy",
           	     clearBtn: true,
           	     todayHighlight: true,
           	     daysOfWeekHighlighted: "0",
                })});
       </script>
      
       <script type="text/javascript">
       $(function () {
    	   $('.input-daterange').datepicker({
         	     format: "dd/mm/yyyy",
           	     clearBtn: true,
           	     startDate: "0",
           	     todayHighlight: true,
           	     daysOfWeekHighlighted: "0"
    	   });
			});
       </script>
  
  
<div class="container">
  <div class="jumbotron">
  <br><br><br>
<h2 class="text-center">
<spring:message code="route.create" />
</h2>

<form:form action="route/customer/edit.do" modelAttribute="route" class="form-horizontal">
 <br>
 
 	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="rating" />
	<form:hidden path="customer" />
	
		
 <div class='col-md-6'>
	<div class="form-group" >
	
	<form:label path="name" class="col-sm-5 control-label">
		<spring:message code="route.name" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="name" class="form-control" />
	<form:errors cssClass="error" path="name" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="description" class="col-sm-5 control-label">
		<spring:message code="route.description" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:textarea path="description" class="form-control" />
	<form:errors cssClass="error" path="description" />
		</div>
	</div>
</div>
	

	<div class='col-md-6'>
	
	<form:label path="startingDate" class="col-sm-5 control-label">
		<spring:message code="activity.dateRange" />:
	</form:label>
	
<div class="form-group">
                        
   	<div class="col-xs-6">
		<div class="input-daterange input-group" id="datepicker">
			<form:input path="startingDate" class="form-control" />
			<span class="input-group-addon">to</span>
			<form:input path="endDate" class="form-control" />
			<span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
           <form:errors cssClass="error" path="startingDate" />
		</div>
	</div>
		
	<div class="form-group" >
	
	<form:label  path="activities" class="col-sm-5 control-label">
		<spring:message code="route.activities" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select multiple="multiple" path="activities" class="form-control">
		<form:option value="0">----</form:option>
		<form:options
			items="${activities}"
			itemLabel="name"
			itemValue="id"
		/>
	</form:select>
	<form:errors cssClass="error" path="activities" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label  path="categories" class="col-sm-5 control-label">
		<spring:message code="route.categories" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select multiple="multiple" path="categories" class="form-control">
		<form:option value="0">----</form:option>
		<form:options
			items="${categories}"
			itemLabel="name"
			itemValue="id"
		/>
	</form:select>
	<form:errors cssClass="error" path="activities" />
		</div>
	</div>
		
  </div>
<br>


<br>

<div class="form-group" align="center">


	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="activity.save" />" />
		&nbsp;
		
	<jstl:if test="${route.id != 0}">
		<input type="submit" name="delete" class="btn btn-primary"
			value="<spring:message code="activity.delete"/>"
			onclick="return confirm('<spring:message code="activity.confirm.delete" />')" />
		&nbsp;
	</jstl:if>
	
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="activity.cancel" />"
		onclick="javascript: window.location.replace('security/login.do');" /> 
	
	</div>
</form:form>
</div>
</div>