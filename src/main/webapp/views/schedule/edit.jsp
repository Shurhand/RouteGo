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
	
	
  <div class='col-md-5'>
	<div class="form-group" >
	
	<form:label path="dayOfWeek" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
		<form:select path="dayOfWeek" class="form-control">
		<form:option value="MONDAY"><spring:message code="schedule.monday" /></form:option>
		<form:option value="TUESDAY"><spring:message code="schedule.tuesday" /></form:option>
		<form:option value="WEDNESDAY"><spring:message code="schedule.wednesday" /></form:option>
		<form:option value="THURSDAY"><spring:message code="schedule.thursday" /></form:option>
		<form:option value="FRIDAY"><spring:message code="schedule.friday" /></form:option>
		<form:option value="SATURDAY"><spring:message code="schedule.saturday" /></form:option>
		<form:option value="SUNDAY"><spring:message code="schedule.sunday" /></form:option>
	</form:select>
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="openingDate" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
		<form:input path="openingDate" class="form-control input-small" id="timepicker1" />
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
		<form:errors cssClass="error" path="openingDate" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
		<form:input path="closingDate" class="form-control input-small" id="timepicker2" />
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
		</div>
		<form:errors cssClass="error" path="closingDate" />
		</div>
	</div>
	
	
	</div>
	
	
	<div class='col-md-5'>
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

	<jstl:if test="${message != null}">
		<p align="center" class="error">
		<spring:message code="schedule.commit.error" />
		</p>
	</jstl:if>
	
</div>
</div>

        <script type="text/javascript">
            $('#timepicker1').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>
        
                <script type="text/javascript">
            $('#timepicker2').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00'
            });
        </script>
        
        <script type="text/javascript">
       	 function checkMyDateWithinRange(){
       		
       		var openingDate = document.getElementById(openingDate);
       		var closingDate = document.getElementById(closingDate);
       	 	if(openingDate > closingDate){
       	 		alert("The time range is not valid");
       	 	}
       	 }
        </script>
        