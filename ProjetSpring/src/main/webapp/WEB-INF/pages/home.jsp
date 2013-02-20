<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!DOCTYPE html> 
<html>
<head>
	<%-- TITRE DE LA PAGE --%>
	<title>HOME</title>
	
	<%-- META INFORMATIONS --%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<%-- CSS --%>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>">
	<style type="text/css">
	<!--
	
	body{
		margin: 0;
		padding: 0;
		overflow: hidden;
	}
	
	#tchat{
		position:absolute;
		margin: 0;
		padding: 0;
		left: 0;
		top: 0;
		width: 80%;
		height: 95%;		
		overflow-y:scroll;
			
	}
	
	#tchat > *{
		margin: 4px
	}
	
	#formTchat{
		position: absolute;
		margin: 0;
		padding: 0;
		bottom: 0;
		left: 0;
		width: 80%;
		height: 5%;
	}
	
	#formTchat form{
		height: 100%;
		margin: 0;
		padding: 0;
		background: #eee;
	}
	
	#formTchat textarea{
		height: 100%;
		width: 100%;
	}
	
	#contact-list{
		position: absolute;
		margin: 0;
		padding: 0;
		right: 0;
		top: 0;
		width: 20%;	
		height: 95%;
		overflow-y: scroll;
		background-color: #f5f5f5;
	
	}
	
	#contact-list > *{
		margin: 4px
	}
	
	-->	
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
	
			<%-- GAUCHE --%>
			<div class="span10">
			
				<%-- DISCUSSIONS --%>
				<div id="tchat">
					<%-- ONGLET --%>
					<ul class="nav nav-tabs" id="tabs">
						<li class="active"><a href="#onglet-1" data-toggle="tab">Gautier</a></li>
						<li><a href="#onglet-2" data-toggle="tab">Cyriel</a></li>
					</ul>
					
					<div class="tab-content">
						<div class="tab-pane active" id="#onglet-1">
							<blockquote>
								<small><strong>gautier :</strong></small>
								Hi !
							</blockquote>
							<hr>
							<blockquote>
								<strong>me :</strong>
								Hi ! How are you?
							</blockquote>
						</div>
						
						<div class="tab-pane" id="#onglet-2">aa</div>
					</div>
				</div>
				
				<%-- FORMULAIRE DE DISCUSSION --%>
				<div id="formTchat">
					<form method="post" action="javascript:void(0);">
						<div class="input-append">
							<textarea name="message" id="message" required="required" maxlength="255" rows="1"></textarea>
							<button type="button" class="btn" >Send</button>				
						</div>
					</form>
				</div>
			
			</div>
			
			<%-- DROITE --%>
			<div class="span2">
			
				<%-- CONTACT LISTE --%>
				<ul class="nav nav-list nav-stacked" id="contact-list">
					<li class="nav-header">Mes Amis</li>
					<li><a href="accueil.html">Cyriel <i class="icon-comment pull-right"></i></a></li>
				</ul>
			
			
			</div>
			
			
		</div>
	</div>
	
	<%-- JAVASCRIPT --%>
	<script src="http://code.jquery.com/jquery.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>