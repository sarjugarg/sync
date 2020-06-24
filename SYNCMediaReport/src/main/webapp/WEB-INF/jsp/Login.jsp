<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${context}/resources/css/loginstyle.css" rel="stylesheet"/>
<script src="${context}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${context}/resources/js/bootstrap.min.js"></script>
<link href="${context}/resources/css/style.css" rel="stylesheet"/>
</head>
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper ">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="${context}/resources/images/User-icon.png" id="icon" alt="User Icon" />
    </div>
  
<label class="loginLabel">MEMBER LOGIN</label><br>
<span style="color:#ff2007; font-size:12px;">${msg}</span>  
    <!-- Login Form -->
    <form:form modelAttribute="user" method="post" action="./Main">
      <form:input path="username" type="text" id="login" class=" second" name="login" placeholder="User Name"/>
      <form:input path="password" type="password" id="password" class=" third" name="login" placeholder="Password"/>
      <input type="submit" class=" fourth" value="Log In">
    </form:form>

    <!-- Remind Passowrd -->
 <!--    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div> -->

  </div>
</div>
</html>