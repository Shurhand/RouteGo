<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


      <nav class="navbar-sinmargen navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/RouteGo/">routeGo</a>
          <a href="?language=en"><img src="images/icon_id_en.png"></a>
          <a href="?language=es"><img src="images/icon_id_es.png"></a>
        </div>
      </div>
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Visits <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Activities</a></li>
                <li><a href="#">Routes</a></li>
                <li><a href="#">Custom Routes</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Companies</a></li>
              </ul>
            </li>
          </ul>
          <security:authorize access="isAnonymous()">
          <div id="navbar" class="navbar-collapse collapse">
          <form:form class="navbar-form navbar-right" action="login" modelAttribute="credentials">
            <div class="form-group">
             	<form:input path="username" class="form-control" />
				<form:errors class="error" path="username" />
            </div>
            <div class="form-group">
             	<form:password path="password" class="form-control" />
				<form:errors class="error" path="password" />
			</div>
			<div class="form-group">
			<jstl:if test="${showError == true}">
				<div class="error2">
					<spring:message code="security.login.failed" />
				</div>
			</jstl:if>
			</div>
			 <div class="form-group">
            <input type="submit" class="btn btn-primary" value="<spring:message code="master.page.login" />" />
            <a href="customer/create.do" class="btn btn-primary"> <spring:message code="master.page.register" /></a>
           </div>
           </form:form>
           </div>
         </security:authorize>
          <security:authorize access="isAuthenticated()">
          
			 <div id="navbar" class="navbar-collapse collapse">
			 <form:form class="navbar-form navbar-right">
			<div class="form-group">
				<p class="navbar-text navbar-right2"><spring:message code="master.page.salute" /><br>  <security:authentication property="principal.username" /></p> 
			 	<a class="btn btn-primary" href="logout" ><spring:message code="master.page.logout"/></a>
			</div>
	</form:form>
	</div>
	
		
			</security:authorize>
          
        </div><!--/.navbar-collapse -->
          <!--<ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Default</a></li>
            <li class="active"><a href="./">Static top <span class="sr-only">(current)</span></a></li>
            <li><a href="../navbar-fixed-top/">Fixed top</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
