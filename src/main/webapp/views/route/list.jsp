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

<link href="styles/comment.css" media="all" rel="stylesheet" type="text/css" />

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
					<c:if test="${hi <= 22}">
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
					<td width="25%" align="center" style="vertical-align:middle;">
					
					<c:if test="${mi == 0}">
					<c:out value="${hi}"  />:<c:out value="00"  />&nbsp; -&nbsp;
					</c:if>
					
					<c:if test="${mi != 0}">
					<c:out value="${hi}"  />:<c:out value="${mi}"  />&nbsp; -&nbsp;
					</c:if>
					
					<c:if test="${mf == 0}">
					<c:out value="${hf}"  />:<c:out value="00"  /></td>
					</c:if>
					
					<c:if test="${mf != 0}">
					<c:set var="aux" value="00"></c:set>
					<c:out value="${hf}"  />:<c:out value="${mf}"  /></td>
					</c:if>
					
					
					<td width="30%" align="center" style="vertical-align:middle;"><jstl:out value="${activity.name}" /></td>
					<td width="20%" align="center" style="vertical-align:middle;"><jstl:out value="${activity.cost} Euros " /></td>
					<c:set var="total" value="${activity.cost + total}" />
					
					
					<c:set var="hi" value="${hf}" />
					<c:set var="mi" value="${mf}" />
					</c:if>
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
	
	<jstl:if test="${route.details != null}">
	<p align="center">
		<b><spring:message code="route.details" /></b>
	</p>
			
	<div class="panel panel-default">
  		<div class="panel-body"><jstl:out value="${route.details}  " /></div>
	</div>
	</jstl:if>		
		
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
    var geocoder = new google.maps.Geocoder();
    var polys = new google.maps.Polyline({
	    geodesic: true,
	    strokeColor: '#4986E7',
	    strokeOpacity: 1.0,
	    strokeWeight: 5
	  });
  
    var service = new google.maps.DirectionsService(),snap_path=[];    

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
    var address = "${n.postalAddress}";
    if (geocoder) {
    geocoder.geocode({'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
          map.setCenter(results[0].geometry.location);
    
    
      marker = new google.maps.Marker({
        position:  results[0].geometry.location,
        map: map,
//         icon: image
      });
      markersArrayPositions.push(results[0].geometry.location);
      markersArray.push(marker);
      
      google.maps.event.addListener(marker, 'mouseover', (function(marker, i) {
        return function() {
         infowindow.setContent("${n.name}");
         infowindow.open(map, marker);
        }
      })(marker, i));
      
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
      
      
        } else {
            alert("No results found");
          }
        } else {
          alert("Geocode was not successful for the following reason: " + status);
        }
      });
    }
    
    
      
      </c:forEach>
  
      polys.setMap(map);
      
      
</script>

<jstl:if test="${estaAsignada}">
<div class="detailBox">
    <div class="titleBox">
      <label><spring:message code="route.comment.box" /></label>
    </div>
    <div class="commentBox">
        
        <p class="taskDescription"> <jstl:out value="${route.name}"></jstl:out> </p>
    </div>
    <div class="actionBox">
        <ul class="commentList">
            <li>
                <div class="commentText">
                	<display:table name="comments" id="row">
                	<display:column>
                	<div class="commentBox">
                	<span class="date sub-text"><jstl:out value="${row.customer.name}"></jstl:out></span>
                    <p class="sub-texto"><jstl:out value="${row.text}"></jstl:out> </p> <span class="date sub-text"><jstl:out value="${row.moment}"></jstl:out></span>
                    </div>
					</display:column>
					</display:table>
                </div>
            </li>
        </ul>
        <form:form action="route/customer/comment.do" modelAttribute="route" ss="form-inline">
            <div class="form-group">
            	<input class="form-control" type="text" placeholder="<spring:message code="route.your.comments" />" name="text"/>
  				<input type="hidden" name="routeId" value="<%= request.getParameter("routeID") %>"/>
            </div>
            <div class="form-group">
                <input type="submit" name="comment" class="btn btn-default custom" value="<spring:message code="route.comment" />" />
            </div>
        </form:form>
    </div>
</div>
</jstl:if>