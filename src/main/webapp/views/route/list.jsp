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

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>

</head>


<div class="container-fluid">
	<div class="jumbotron">
		<div class="row">
			<br>
			<br>
			<br>
		
			<p align="center">${route.name}<br><br>

				<b><spring:message code="route.startingDate" /></b>
				<jstl:out value="${startingDate}  " />&nbsp;
				<b><spring:message code="route.endDate"  /></b>
				<jstl:out value="${endDate}" />
				<br> <br>
				<br>
			</p>

			<div class='col-md-6'>
				<div id="map" style="width: 100%; height: 400px;"></div>
			</div>

			<div class='col-md-6'>
				<% int i=9, j=10;%>
				<table class="table table-striped table-bordered">
				<thead class="thead-inverse">
				    <tr>
				      <th style="text-align:center">Picture</th>
				      <th style="text-align:center">Duration</th>
				      <th style="text-align:center">Name</th>
				      <th style="text-align:center">Cost</th>
				    </tr>
				  </thead>
				  <tbody>
				 <c:set var="total" value="0" />
				 	<c:set var="hi" value="10" />
					<c:set var="mi" value="00" />

				<jstl:forEach var="activity" items="${route.activities}">
					<tr>
					<% i++; j++; %>
					<c:set var="mt" value="${(hi*60)+mi}" />
					
					<c:set var="mt" value="${mt + activity.duration}" />
					
					<c:set var="hf" value="${mt / 60}" />
					<!--  Para quedarnos con la parte entera de hf y quedarnos que con las horas usamos la siguiente funci�n 
					hay que cambiar  value="${hi}" por value="${hf}" pero parece que el dato viene como si fuera un string (desde mt) y da fallo-->
					
					<fmt:parseNumber var="hf" integerOnly="true" type="number" value="${hf}" />
					
					<c:set var="mf" value="${mt % 60}" />
					<!-- Igual que el anterior caso hay que cambiar  value="${mi}" por value="${mf}"-->
					
					<fmt:parseNumber var="mf" integerOnly="true" type="number" value="${mf}" />
					
					
					<td width="25%" align="center" style="vertical-align:middle;"><img var="p" width="60%" src="${activity.picture}" /></td>
				
					<!--<td width="25%" align="center" style="vertical-align:middle;"><% //out.println(i + ":00 - "+ j +":00"); %></td>-->
					<td width="25%" align="center" style="vertical-align:middle;"><c:out value="${hi}"  />: <c:out value="${mi}"  />&nbsp;-&nbsp;<c:out value="${hf}"  />: <c:out value="${mf}"  /></td>
					<td width="30%" align="center" style="vertical-align:middle;"><jstl:out value="${activity.name}" /></td>
					<td width="20%" align="center" style="vertical-align:middle;"><jstl:out value="${activity.cost} Euros " /></td>
					<c:set var="total" value="${activity.cost + total}" />
					<c:set var="hi" value="${hf}" />
					<c:set var="mi" value="${mf}" />
					</tr>
				</jstl:forEach>
					<tr>
					<td width="25%" align="center" style="vertical-align:middle;">Total</td>
					<td colspan="3" width="75%" align="right" style="vertical-align:middle;"> <b>	<c:out value="${total}"  /> Euros &nbsp; </b></td>
					</tr>
 				 </tbody>
				</table>
			</div>

		</div>
		
	<br>
	<!-- Formulario para guardar la ruta en la base de datos -->
		
	<form:form action="route/list.do" modelAttribute="route">
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	       
	<div class="form-group">
		<div class="col-xs-5"></div>

	<security:authorize access="isAnonymous()">
	<button id="tooltip" type="button" data-toggle="tooltip" data-placement="bottom" title="<spring:message code="popover.content" />" class="btn btn-primary"
		><spring:message code="route.save" /></button>
		&nbsp;
	</security:authorize>
	
	<security:authorize access="hasAuthority('CUSTOMER')">
	<input type="submit" name="save" class="btn btn-primary"
		value="<spring:message code="route.save" />" />
		&nbsp;
	</security:authorize>	
		
	<input type="button" name="cancel" class="btn btn-primary"
		value="<spring:message code="route.renew" />"
		onclick="reload()" /> 
	</div>
	</form:form>
	
	</div>
</div>

<script type="text/javascript">
function reload() {
	window.location.reload(true);
}
</script>

<script type="text/javascript"> 
$(function() {
	$('#tooltip').tooltip();
   });
 </script>

<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
   

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 14,
      center: new google.maps.LatLng(37.3824, -5.9965),
      mapTypeId: google.maps.MapTypeId.ROADMAP
      
    });

   var infowindow = new google.maps.InfoWindow();

    var marker, i;
    var markersArrayPositions = new Array();
    var markersArray = new Array();

    <c:forEach items="${route.activities}" var="n"> 
  
//  =========== Posibilidad de cambiar el icono de los marcadores ============= 
//     var image = {
//     	    url: "${n.picture}",
//     	    // This marker is 20 pixels wide by 32 pixels high.
//     	    size: new google.maps.Size(64, 32),
//     	    // The origin for this image is (0, 0).
//     	    origin: new google.maps.Point(0, 0),
//     	    // The anchor for this image is the base of the flagpole at (0, 32).
//     	    anchor: new google.maps.Point(0, 32)
//     	  };
    
    
    
      marker = new google.maps.Marker({
        position: new google.maps.LatLng("${n.latitude}", "${n.longitude}"),
        map: map,
//         icon: image
      });
      markersArrayPositions.push(marker.getPosition());
      markersArray.push(marker);
      
      google.maps.event.addListener(marker, 'mouseover', (function(marker, i) {
        return function() {
         infowindow.setContent("${n.name}");
         infowindow.open(map, marker);
        }
      })(marker, i));
      </c:forEach>
      
      
      var polys = new google.maps.Polyline({
    	    geodesic: true,
    	    strokeColor: '#4986E7',
    	    strokeOpacity: 1.0,
    	    strokeWeight: 5
    	  });
      
      var service = new google.maps.DirectionsService(),snap_path=[];               
      
        for(j=0; j < markersArray.length - 1; j++){            
              service.route({
            	  origin: markersArrayPositions[j],
            	  destination: markersArrayPositions[j+1],
            	  travelMode: google.maps.DirectionsTravelMode.WALKING},
            	  		function(result, status) {                
                  if(status == google.maps.DirectionsStatus.OK) {                 
                        snap_path = snap_path.concat(result.routes[0].overview_path);
                        polys.setPath(snap_path);
                  }        
              });
      }
        
       	// ============= Unión del último punto y el primero. (NO SIEMPRE FUNCIONA) ================
        service.route({
      	  origin: markersArrayPositions[0],
      	  destination: markersArrayPositions[markersArray.length - 1],
      	  travelMode: google.maps.DirectionsTravelMode.WALKING},
      
  		function(result, status) {  
      	  if(status == google.maps.DirectionsStatus.OK) {                 
      		polys.push(result.routes[0].overview_path);
        }        
    });
   
      polys.setMap(map);
      
      
</script>

<div class="container">
  <div class="jumbotron">
  <br><br><br>
<h2 class="text-center">
<spring:message code="route.comments" />
</h2>

<form:form action="route/customer/comment.do" modelAttribute="route" class="form-horizontal">
	
	<input id="input-id" name="text" type="text" size="35"/>
  	<input type="hidden" name="routeId" value="<%= request.getParameter("routeID") %>"/>
  	<input type="submit" name="comment" class="btn btn-primary" value="<spring:message code="route.comment" />" />

</form:form>

<br>

<div class="container-fluid">
<div class="table-responsive">
<display:table name="comments" id="row" requestURI="${requestURI}"
	pagesize="5" class="table table-hover">
	
	<spring:message code="comment.text" var="textHeader"/>
	<display:column property="text" title="${textHeader}" sortable="false"/>
	
	<spring:message code="comment.customer" var="customerHeader"/>
	<display:column property="customer.name" title="${customerHeader}" sortable="false"/>
	
	<spring:message code="comment.moment" var="momentHeader"/>
	<display:column property="moment" title="${momentHeader}" sortable="true"/>
	
</display:table>
</div>
</div>
</div>
</div>

