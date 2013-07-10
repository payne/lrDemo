<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>

<head>
    <title>userData</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
</head>

<body>
<c:forEach items="${userDataList}" var="ud">
    <div class="userData">${ud.name} ${ud.surname} of age ${ud.age} </div>
</c:forEach>

 <c:if test="${not empty userData}">
<h2>one specific user:</h2>
    <div class"userData">${userData.name} ${userData.surname} of age ${userData.age} </div>
</c:if>


<h2>get UserData with ajax...</h2>
<div id="container">
    <form id="nameForm">
      <div class="error hide" id="idError">Please enter a valid name</div>
      <label for="name">Name</label><input name="name" id="name"/>
      <input type="submit" value="Get userData"/> <br/><br/>
      <div id="userDataResponse"> </div>
    </form>

</div>


 <script type="text/javascript">
     var ctx = "/userdata";  //"${pageContext.request.contextPath}";
    $(document).ready(function() {
      // Request Person by ID AJAX
      $('#nameForm').submit(function(e) {
        var name = $('#name').val();
        //if(!validatePersonId(personId))
        //  return false;

        $.getJSON(ctx + '/json/' + name, function(userData) {
          $('#userDataResponse').text(userData.name + ', age ' + userData.age);
        });
        e.preventDefault(); // prevent actual form submit
      });
    });



  </script>

</body>

</html>