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
<display:table name="routes" id="row" requestURI="route/customer/list2.do"
	pagesize="5" class="table table-hover">
	
	<spring:message code="route.name" var="nameHeader"/>
	<display:column property="name" title="${nameHeader}" sortable="true"/>
	
	<spring:message code="route.description" var="descriptionHeader"/>
	<display:column property="description" title="${descriptionHeader}" sortable="false"/>
	
	<spring:message code="route.startingDate" var="startingDateHeader"/>
	<display:column property="startingDate" title="${startingDateHeader}" sortable="false"/>
	
	<spring:message code="route.endDate" var="endingDateHeader"/>
	<display:column property="endDate" title="${endingDateDateHeader}" sortable="false"/>
	
	<spring:message code="route.purchase" var="purchaseHeader"/>
	<display:column title="${purchaseHeader}" sortable="false">
	<jstl:if test="${row.isRandom==false && row.customer==principal}">					
	<a href="COMPRAR.do?orderId=<jstl:out value="${row.id}"/>"><spring:message code="route.purchase" /> </a>
	</jstl:if>
	</display:column>
		
</display:table>
	
	<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
		<input type="text" name="cmd" value="_s-xclick">
		<input type="text" name="hosted_button_id" value="Q6TK64BQ8A4QL">
		<input type="image" src="https://www.paypalobjects.com/es_ES/ES/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal. La forma rápida y segura de pagar en Internet.">
		<img alt="" border="0" src="https://www.paypalobjects.com/es_ES/i/scr/pixel.gif" width="1" height="1">
	</form>
	
	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" target="_top">
	<input type="hidden" name="cmd" value="_s-xclick">
	<input type="hidden" name="hosted_button_id" value="8GSQF4BXWF9X2">
	<input type="image" src="https://www.sandbox.paypal.com/es_ES/ES/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal. La forma rápida y segura de pagar en Internet.">
	<img alt="" border="0" src="https://www.sandbox.paypal.com/es_ES/i/scr/pixel.gif" width="1" height="1">
</form>


<br><br><br><br><br>
<form action='expresscheckout.asp' METHOD='POST'>
<input type='image' name='submit' src='https://www.paypal.com/en_US/i/btn/btn_xpressCheckout.gif' border='0' align='top' alt='Check out with PayPal'/>
</form>

	


<br>

</div>