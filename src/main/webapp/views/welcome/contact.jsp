<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<br><br><br><br><br><br>
<div class="container" >
  <div class="row" >
    <div class="box" style="background-color:white; border: 1px solid #DDD; border-radius: 10px; max-width: 800px;  margin: auto;">   


	<form>
    <legend><spring:message code="contact.title"/></legend>
    <!--<legend>Enviar un correo electrónico. Todos los campos con el asterisco ('*') son obligatorios.</legend>-->
    <div class="form-group">
        <label for="InputName1"><spring:message code="contact.name"/></label>
        <input type="name" class="form-control" id="InputName1" placeholder="Name" required>
    </div>
    <div class="form-group">
        <label for="InputSubject1"><spring:message code="contact.subject"/></label>
        <input type="subject" class="form-control" id="exampleInputSubject1" placeholder="Subject">
    </div>
    <div class="form-group">
        <label for="InputEmail1"><spring:message code="contact.email"/></label>
        <input type="email" class="form-control" id="InputEmail1" placeholder="Email" required>
    </div>
    <div class="form-group">
        <label for="InputMessage1"><spring:message code="contact.message"/></label>
        <textarea type="message" class="form-control" id="InputEmail1" placeholder="Message" required></textarea>
    </div>
    <div class="checkbox">
        <label>
        <input type="checkbox"> <spring:message code="contact.copy"/>
        </label>
    </div>
    <button type="submit" class="btn btn-primary"><spring:message code="contact.send"/></button>
    <button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right" title="Tooltip on right">Tooltip on right</button>
    <a  role="button" class="btn btn-warning js-popover" title="A Title" data-content="And" data-placement="left">button</a> 
    <button type="button"  class="btn btn-danger" data-toggle="alert">Send Message</button>
        <div class="parent">

    <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
      <div class="modal-content">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Modal Heading</h4>
        </div>
        <div class="modal-body">


          <h4>aaaaaa</h4>
          <p>bbbbb</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>

      </div>
    </div>
  </div>
    <hr>
  <button class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
    Modal
  </button>

</form>
</div>

</div>
</div>

<br>
  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- JavaScript Includes 
    <script src="./js/jquery.min.js"></script>
    <script src="./js/transition.js"></script>
    <script src="./js/tooltip.js"></script>-->

    <!-- JavaScript Test -->
    
    <script>
    //tooltip
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
      $('.js-popover').popover()
    });
    //alert
    $(document).ready(function () {

    $('[data-toggle="alert"]').click(function () {
      
            $('.parent').append("<div class='alert alert-success alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>Success! message sent successfully.</div>")



    })

    });


    </script>


     <!-- 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    //<script>window.jQuery || document.write('<script src="./js/jquery.min.js"><\/script>')</script>
    <script src="./js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <!-- <script src="./js/ie10-viewport-bug-workaround.js"></script>-->
  </body>