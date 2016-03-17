<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="images/Banner1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <div class="carousel-p">
                <h1>Enjoy with our new activities.</h1>
                <p>Multicultural activities for all ages in Seville.</p>
                <p><a class="btn btn-lg btn-primary" href="customer/create.do" role="button">Sign up today</a></p>
              </div>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="images/Banner6.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <div class="carousel-p">
                <h1>Visit Seville.</h1>
                <p>Enjoy every corner of the city with our Routes.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              </div>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="images/Plaza-España.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <div class="carousel-p">
                <h1>Do you know our custom routes?</h1>
                <p>routes created by people who know the city</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
    
        <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1 align="center">Do you like to travel to Seville ?</h1>
        <p align="center">Make your next holiday awesome! Build your own day-by-day trip plan in just minutes</p>
      
		<p align="center">
         <a class="btn btn-lg btn-primary " href="route/create.do" role="button"><spring:message code="index.trip"/></a>
		</p>
      </div>

    </div> <!-- /container -->
