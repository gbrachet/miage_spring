<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html> 
<html>
<head>
	<%-- TITRE DE LA PAGE --%>
	<title>WELCOME</title>
	
	<%-- META INFORMATIONS --%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<%-- CSS --%>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>">
    <style type="text/css">
	body {
		padding-top: 50px;
		padding-bottom: 50px;
		background-color: #f5f5f5;
	}
	
	#tabs {
		margin: 0;
	}
	
	.tab-content {
		margin: 0;
		padding: 19px 29px 29px;
		background-color: #fff;
		border: 1px solid #ddd;
		border-width: 0 1px 1px 1px;
		-webkit-border-radius: 0 0 4px 4px;
		-moz-border-radius: 0 0 4px 4px;
		border-radius: 0 0 4px 4px;
	}
	
	#content {
		max-width: 500px;
		padding: 19px 29px 29px;
		margin: 0 auto 20px;
	}
	
	input[type="text"],
	input[type="email"],
	input[type="password"],
	select {
		font-size: 1.5em;
		height: auto;
		margin-bottom: 15px;
		padding: 7px 9px;
	}
	</style>
</head>
<body>
	<div class="container">
		<div class="row-fluid">
		
				<div id="content">
		
				<%-- ONGLET --%>
				<ul class="nav nav-tabs" id="tabs">
					<li <c:if test="${tab=='signin'}">class="active"</c:if>><a href="#signin" data-toggle="tab">Sign In</a></li>
					<li <c:if test="${tab=='register'}">class="active"</c:if>><a href="#register" data-toggle="tab">Register</a></li>
				</ul>
				
				<div class="tab-content">
					<div class="tab-pane <c:if test="${tab=='signin'}">active</c:if>" id="signin">
						<c:url var="loginUrl" value="/signin"/>
						<form:form modelAttribute="user" method="post" action="${loginUrl}">
					 		<h2>Please Sign In</h2><br>
					 		
					 		<form:errors path="email" cssClass="text-error" element="div" /><br>
							
	       					<form:input type="email" path="email" class="input-block-level" placeholder="Email address" maxlength="72" required="required" />
	       					
	        				<form:input type="password" path="password" class="input-block-level" placeholder="Password" maxlength="16" required="required" />

							<hr>
	        				
	        				<button class="btn btn-large btn-primary pull-right" type="submit"><i class="icon-ok-sign icon-white"></i> Sign in</button> 
						</form:form>
					</div>
					
					<div class="tab-pane <c:if test="${tab=='register'}">active</c:if>" id="register">
						<c:url var="registerUrl" value="/register"/>
						<form:form modelAttribute="userForm" method="post" action="${registerUrl}">
							<h2>Sign up for Free</h2><br>
							
							<form:input type="email" path="email" class="input-block-level" placeholder="Email address*" maxlength="72" required="required" />
							<form:errors path="email" cssClass="text-error" element="div" /><br>
							
							<form:input type="password" path="password" class="input-block-level" placeholder="Password*" maxlength="16" required="required" />
							<form:errors path="password" cssClass="text-error" element="div" /><br>
							
							<form:input type="password" path="passwordConfirm" class="input-block-level" placeholder="Confirm Password*" maxlength="16" required="required" />
							<form:errors path="passwordConfirm" cssClass="text-error" element="div" /><br>
							
							<form:select path="sex" class="input-block-level">
								<form:option value="" selected="selected"></form:option>
								<form:option value="f">Female</form:option>
								<form:option value="m">Male</form:option>
							</form:select>
							<form:errors path="sex" cssClass="text-error" element="div" /><br>
							
							<form:input type="text" path="birthday" class="input-block-level" placeholder="Birthday : dd/mm/yyyy" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}" required="required" />
							<form:errors path="birthday" cssClass="text-error" element="div" /><br>
							
							<hr>
							<div class="pull-left">
								<i class="icon-asterisk"></i> <strong>required</strong>
							</div>
							<button class="btn btn-large btn-primary pull-right" type="submit"><i class="icon-check icon-white"></i> Sign up</button> 
						</form:form>
					</div>
				</div>
			</div>
			
			</div>
	</div>
	
	<%-- JAVASCRIPT --%>
	<script src="http://code.jquery.com/jquery.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>