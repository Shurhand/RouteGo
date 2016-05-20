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
       
       <script type="text/javascript">
       var cont= 0;
       function showDiv() {
    	   cont= cont +1;
    	   document.getElementById('div'+cont).style.display = "block";
    	   $("#dayOfWeek"+cont).removeAttr('disabled');
    	   $("#clTimePicker"+cont).removeAttr('disabled');
    	   $("#opTimePicker"+cont).removeAttr('disabled');
       }
		</script>
  
  
<div class="container">
  <div class="jumbotron">
  <br><br><br>
<h2 class="text-center">
<spring:message code="activity.create" />
</h2>

<form:form action="activity/create.do" modelAttribute="activityForm" class="form-horizontal">
 <br>
  	
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
	
	<form:label path="picture" class="col-sm-5 control-label">
		<spring:message code="activity.picture" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="picture" class="form-control" />
	<form:errors cssClass="error" path="picture" />
		</div>
	</div>
		
</div>
	<div class='col-md-6'>
		
	<div class="form-group" >
	
	<form:label path="duration" class="col-sm-5 control-label">
		<spring:message code="activity.duration" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:input path="duration" class="form-control" />
	<form:errors cssClass="error" path="duration" />
		</div>
	</div>
	
	<form:label path="startingDate" class="col-sm-5 control-label">
		<spring:message code="activity.dateRange" />:
	</form:label>
	
<div class="form-group">
                        
   	<div class="col-xs-6">
		<div class="input-daterange input-group" id="datepicker">
			<form:input path="startingDate" class="form-control" />
			<span class="input-group-addon">to</span>
			<form:input path="endingDate" class="form-control" />
			<span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
           <form:errors cssClass="error" path="startingDate" />
		</div>
	</div>
		
	<!--  
	<div class="form-group" >
	
	<form:label path="startingDate" class="col-sm-5 control-label">
		<spring:message code="activity.startingDate" />:
	</form:label>
	
	<div class="col-xs-6">
		<div class='input-group date' id='datepicker1'>
			<form:input path="startingDate" class="form-control" />
			
			<span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
           <form:errors cssClass="error" path="startingDate" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="endingDate" class="col-sm-5 control-label">
		<spring:message code="activity.endingDate" />:
	</form:label>
	
		<div class="col-xs-6">
		<div class='input-group date' id='datepicker2'>
			<form:input path="endingDate" class="form-control" />
			<span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
           <form:errors cssClass="error" path="endingDate" />
		</div>
	</div>
	-->
	<div class="form-group" >
	
	<form:label  path="categories" class="col-sm-5 control-label">
		<spring:message code="activity.categories" />:
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
	<form:errors cssClass="error" path="categories" />
		</div>
	</div>
		
  </div>
  
<div class='col-md-6' >
	<div id="div1" style="display:none;">
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE1"></jstl:out></h4>
	<form:label path="dayOfWeek1" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek1" class="form-control" disabled="true">
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
	
	<form:label path="openingDate1" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate1" class="form-control input-small" id="opTimePicker1" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate1" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate1" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate1" class="form-control input-small" id="clTimePicker1" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate1" />
		</div>
	</div>
	</div>
</div>
<div class='col-md-6'>
	<div id="div2" style="display:none;" >
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE2"></jstl:out></h4>
	<form:label path="dayOfWeek2" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek2" class="form-control" disabled="true">
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
	
	<form:label path="openingDate2" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate2" class="form-control input-small" id="opTimePicker2" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate2" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate2" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate2" class="form-control input-small" id="clTimePicker2" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate2" />
		</div>
	</div>
	</div>
</div>
<div class='col-md-6'>	
	<div id="div3"  style="display:none;">
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE3"></jstl:out></h4>
	<form:label path="dayOfWeek3" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek3" class="form-control" disabled="true">
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
	
	<form:label path="openingDate3" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate3" class="form-control input-small" id="opTimePicker3" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate3" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate3" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate3" class="form-control input-small" id="clTimePicker3" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate3" />
		</div>
	</div>
	</div>
</div>
<div class='col-md-6'>
	<div id="div4"  style="display:none;">
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE4"></jstl:out></h4>
	<form:label path="dayOfWeek4" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek4" class="form-control" disabled="true">
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
	
	<form:label path="openingDate4" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate4" class="form-control input-small" id="opTimePicker4" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate4" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate4" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate4" class="form-control input-small" id="clTimePicker4" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate4" />
		</div>
	</div>
	</div>
</div>
<div class='col-md-6'>	
	<div id="div5"  style="display:none;">
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE5"></jstl:out></h4>
	<form:label path="dayOfWeek5" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek5" class="form-control" disabled="true">
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
	
	<form:label path="openingDate5" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate5" class="form-control input-small" id="opTimePicker5" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate5" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate5" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate5" class="form-control input-small" id="clTimePicker5" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate5" />
		</div>
	</div>
	</div>
</div>
<div class='col-md-6'>
	<div id="div6"  style="display:none;">
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE6"></jstl:out></h4>
	<form:label path="dayOfWeek6" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek6" class="form-control" disabled="true">
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
	
	<form:label path="openingDate6" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate6" class="form-control input-small" id="opTimePicker6" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate6" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate6" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate6" class="form-control input-small" id="clTimePicker6" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate6" />
		</div>
	</div>
	</div>
</div>
<div class='col-md-6'>	
	<div id="div7"  style="display:none;">
	<div class="form-group" >
	<h4 align="center" style="color:blue;"><jstl:out value="SCHEDULE7"></jstl:out></h4>
	<form:label path="dayOfWeek7" class="col-sm-5 control-label">
		<spring:message code="schedule.dayOfWeek" />:
	</form:label>
	
	<div class="col-xs-6">
	<form:select path="dayOfWeek7" class="form-control" disabled="true">
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
	
	<form:label path="openingDate7" class="col-sm-5 control-label">
		<spring:message code="schedule.openingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="openingDate7" class="form-control input-small" id="opTimePicker7" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="openingDate7" />
		</div>
	</div>
	
	<div class="form-group" >
	
	<form:label path="closingDate7" class="col-sm-5 control-label">
		<spring:message code="schedule.closingDate" />:
	</form:label>
	
	<div class="col-xs-6">
	<div class="input-group bootstrap-timepicker timepicker">
	<form:input path="closingDate7" class="form-control input-small" id="clTimePicker7" disabled="true"/>
		<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		
	</div>
	<form:errors cssClass="error" path="closingDate7" />
		</div>
	</div>
	</div>

	
</div>
<br>


<br>

<div class="form-group" align="center">

<div class='col-md-12'>
	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="activity.save" />" />
		&nbsp;
		
	<jstl:if test="${activity.id != 0}">
		<input type="submit" name="delete" class="btn btn-primary"
			value="<spring:message code="activity.delete"/>"
			onclick="return confirm('<spring:message code="activity.confirm.delete" />')" />
		&nbsp;
	</jstl:if>
	
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="activity.cancel" />"
		onclick="javascript: window.location.replace('security/login.do');" /> 
	</div>
	
	</div>
</form:form>
<div class='col-md-6'>
<input type="button" name="s1" class="btn btn-info" value="Add Schedule" onclick="showDiv()" />
</div>
</div>
</div>

<script type="text/javascript">
            $('#opTimePicker1').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker1').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>
        
<script type="text/javascript">
            $('#opTimePicker2').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker2').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>
<script type="text/javascript">
            $('#opTimePicker3').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker3').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#opTimePicker4').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker4').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>
        
<script type="text/javascript">
            $('#opTimePicker5').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker5').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>  
        
<script type="text/javascript">
            $('#opTimePicker6').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker6').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>
        
<script type="text/javascript">
            $('#opTimePicker7').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '8:00',
            	
            });
        </script>

<script type="text/javascript">
            $('#clTimePicker7').timepicker({
            	showMeridian: false,
            	minuteStep: 10,
            	defaultTime: '18:00',
            	
            });
        </script>                              