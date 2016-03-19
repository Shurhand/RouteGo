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
			<jstl:out value="${activity.cost} Euros ${activity.name}" /><br>
			
		</jstl:forEach>
</center>

<div id="map" style="width: 500px; height: 400px;"></div>

  <script type="text/javascript">	

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: new google.maps.LatLng(37.3824, -5.9965),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    <c:forEach items="${route.activities}" var="n"> 
      marker = new google.maps.Marker({
        position: new google.maps.LatLng("${n.latitude}", "${n.longitude}"),
        map: map
      });
      
      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent("${n.name}");
          infowindow.open(map, marker);
        }
      })(marker, i));
      </c:forEach>
  </script>

</body>
</html>

