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

<br><br><br><br><br><br><br>
<div class="container-fluid">
<div class="table-responsive">
<display:table name="routes" id="row" requestURI="route/customer/list3.do"
	pagesize="5" class="table table-hover">
	
	<spring:message code="route.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="route.description" var="descriptionHeader"/>
	<display:column property="description" title="${descriptionHeader}" sortable="false"/>
	
	<fmt:formatDate var="startingDate" value="${row.startingDate}" pattern="dd/MM/yyyy" />
	
	<spring:message code="route.startingDate" var="startingDateHeader"/>
	<display:column value="${startingDate}" title="${startingDateHeader}" sortable="false"/>
	
	<fmt:formatDate var="endDate" value="${row.endDate}" pattern="dd/MM/yyyy" />
	
	<spring:message code="route.endDate" var="endingDateHeader"/>
	<display:column value="${endDate}" title="${endingDateHeader}" sortable="false"/>
		
	
	<spring:message code="route.price" var="priceDateHeader"/>
	<display:column title="${priceDateHeader}" sortable="false">
		<c:choose>
			<c:when test="${row.price != 0 && row.price != null}">
				<c:out value="${row.price} Euros"></c:out>
			</c:when>
			<c:otherwise>
			<spring:message code="route.free" var="free"/>
				<c:out value="${free}"></c:out>
			</c:otherwise>
		</c:choose>	
	</display:column>
	
	
	
	<spring:message code="route.display" var="displayHeader"/>
	<display:column title="${displayHeader}" sortable="false">
		<c:choose>	
		<c:when test="${row.price == 0.}">
				
			<a href="route/customer/display.do?routeID=${row.id}"><spring:message code="route.display" /> </a>
		</c:when>	
		
		
		
		<jstl:when test="${row.isRandom==false}">	
		<spring:message code="route.purchase" var="purchaseHeader"/>
	
		<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
	
	  <!-- Identify your business so that you can collect the payments. -->
	  	<input type="hidden" name="business" value="equecrates-facilitator-1@gmail.com">
	
	  <!-- Specify a Buy Now button. -->
	 	 <input type="hidden" name="cmd" value="_xclick">
	
	  <!-- Specify details about the item that buyers will purchase. -->
		  <input type="hidden" name="item_name" value="${row.name}">
		  <input type="hidden" name="item_number" value="${row.id}">
		  <input type="hidden" name="amount" value="${row.price}">
		  <input type="hidden" name="custom" value="${customer.id}">
		  <input type="hidden" name="currency_code" value="EUR">
		  <input type="hidden" name="return" value="http://localhost:8100/RouteGo/route/customer/list2.do">
		  <input type="hidden" name="cancel_return" value="http://localhost:8100/RouteGo/route/customer/listCustom.do">
		   <input type="hidden" name="notify_url" value="http://d111a9e9.ngrok.io/RouteGo/paypal/get.do" />
		  
		  <!-- Display the payment button. -->
		  <input type="image" name="submit" border="0"
		  src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
		  alt="PayPal - The safer, easier way to pay online">
		  <img alt="" border="0" width="1" height="1"
		  src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >
		
		</form>
	
		</jstl:when>

		
		</c:choose>
	</display:column>			
	

	
	
</display:table>
	
<br>

</div>
</div>