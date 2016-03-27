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
<body>
<center>${route.name}<br>

	<jstl:out value="Start Date:${startingDate}"/><br>
	<jstl:out value="End Date:${endDate}"/><br>
	<br><br>
		<jstl:forEach var="activity" items="${route.activities}">
			<img var="p" height="100" width="150" src="${activity.picture}"/>
			<jstl:out value="${p}  ${activity.cost} Euros ${activity.name}" /><br>
			
		</jstl:forEach>
</center>


<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">

    window.onload = function () {
        var mapOptions = {
            center: new google.maps.LatLng(37.3824, -5.9965),
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("dvMap"), mapOptions);
        var infoWindow = new google.maps.InfoWindow();
        var lat_lng = new Array();
        var aux = [];
        var latlngbounds = new google.maps.LatLngBounds();
     	
        
        <c:forEach items="${route.activities}" var="n"> 
        marker = new google.maps.Marker({
          position: new google.maps.LatLng("${n.latitude}", "${n.longitude}"),
          map: map
        });
        aux.push(marker);
        lat_lng.push(new google.maps.LatLng("${n.latitude}", "${n.longitude}"));
     	 
         
     	google.maps.event.addListener(marker, 'mouseover', (function(marker, i) {
            return function() {
              infowindow.setContent("${n.name}");
              infowindow.open(map, marker);
            }
          })(marker, i));
     	</c:forEach>
  
        //***********ROUTING****************//
 
        //Initialize the Path Array
        var path = new google.maps.MVCArray();
 
        //Initialize the Direction Service
        var service = new google.maps.DirectionsService();
 
        //Set the Path Stroke Color
        var poly = new google.maps.Polyline({ map: map, strokeColor: '#4986E7' });
 
        //Loop and Draw Path Route between the Points on MAP
        for (var i = 0; i < lat_lng.length; i++) {
            if ((i + 1) < lat_lng.length) {
                var src = lat_lng[i];
                var des = lat_lng[i + 1];
                path.push(src);
                poly.setPath(path);
                service.route({
                    origin: src,
                    destination: des,
                    travelMode: google.maps.DirectionsTravelMode.WALKING
                }, function (result, status) {
                    if (status == google.maps.DirectionsStatus.OK) {
                        for (var i = 0, len = result.routes[0].overview_path.length; i < len; i++) {
                            path.push(result.routes[0].overview_path[i]);
                        }
                    }
                });
            }
        }
    }
</script>
<div id="dvMap" style="width: 500px; height: 400px">
</div>


</body>
</html>

