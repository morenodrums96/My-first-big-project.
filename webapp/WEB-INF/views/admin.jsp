<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>CineSite administracion | Bienvenido</title> 
	<spring:url value="/resources" var="urlPublic"></spring:url>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">   
    <link href="bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>
  <jsp:include page="includes/menu.jsp"></jsp:include>
<div class="container theme.showcase"role="main">

	<div class="jumbotron">
		<h3>Administracion del sistema</h3>
		<p>Bienvenido <sec:authentication property="principal.usarname"/></p>
	</div>
	<jsp:include page="includes/footer.jsp"></jsp:include>

</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="bootstrap/js/bootstrap.min.js"></script> 
    <script>
      function goBack() {
         window.history.back();
      }
    </script>
  </body>
</html>