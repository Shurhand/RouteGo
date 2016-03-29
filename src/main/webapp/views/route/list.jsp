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


<center>${route.name}<br>

	<jstl:out value="Start Date:${startingDate}"/><br>
	<jstl:out value="End Date:${endDate}"/><br>
	<br><br>
		<jstl:forEach var="activity" items="${route.activities}">
			<img var="p" height="100" width="150" src="${activity.picture}"/>
			<jstl:out value="${p}  ${activity.cost} Euros ${activity.name}" /><br>
			
		</jstl:forEach>
</center>
<div id="map" style="width: 500px; height: 400px;"></div>


<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
   

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
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



