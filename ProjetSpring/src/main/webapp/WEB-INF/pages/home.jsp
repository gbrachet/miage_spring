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
	
	#formTchat .input-append{
		margin: 0;
		width: 99%;
		height: 95%;
	}
	
	#formTchat input{
		height: 99%;
		width: 95%;
	}
	
	#formTchat button{
		height: 100%;
		width: 4.5%;
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
	
	#actions{
		background-color: #eee;
		position: absolute;
		bottom: 0;
		right: 0;
		width: 20%;
		height: 5%;
		text-align:center;
	}
	
	#actions .btn{
		width: 26%;
		height: 100%
	}
	
	#actions .btn-group{
		margin: auto;
		text-align:center;
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
					<ul class="nav nav-tabs" id="tabs"></ul>
					<div class="tab-content"></div>
				</div>
				
				<%-- FORMULAIRE DE DISCUSSION --%>
				<div id="formTchat">
					<form method="post" action="javascript:void(0);">
						<div class="input-append">
							<input name="message" id="message" required="required" maxlength="255" pattern=".+" value="" placeholder="Type your message..." class="input">
							<button type="button" class="btn" id="send">Send</button>				
						</div>
					</form>
				</div>
			
			</div>
			
			<%-- DROITE --%>
			<div class="span2">
			
				<%-- CONTACT LISTE --%>
				<ul class="nav nav-list nav-stacked" id="contact-list">
				</ul>
				
				<%-- BOUTONS --%>
				<div id="actions" class="btn-group">
					<a href="javascript:void(0);" title="Add Contact" class="btn" id="add-contact"><i class="icon-plus"></i></a>
					<a href="javascript:void(0);" title="Remove Contact" class="btn" id="remove-contact"><i class="icon-minus"></i></a>
					<a href="<c:url value="/logout"/>" title="Log Out" class="btn"><i class="icon-off"></i></a>
				</div>
			
			</div>
			
		</div>
	</div>
	
	<%-- MODALS --%>
	<div class="modal hide fade" id="modal-add-contact">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Add Contact</h3>
		</div>
		<div class="modal-body">
			<input type="text" id="input-add-contact" placeholder="Type email..." required="required" maxlength="16" pattern=".*">
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
		</div>
	</div>

	<div class="modal hide fade" id="modal-add-remove">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Remove Contact</h3>
		</div>
		<div class="modal-body">
			<select id="select-remove-contact">
			</select>
			<br>
			<button type="button" class="btn btn-danger" id="remove">Remove</button>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
		</div>
	</div>

	<%-- JAVASCRIPT --%>
	<script src="http://code.jquery.com/jquery.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <c:url var="autoCompleteUrl" value="/ajaxAutoComplete"/>
    <c:url var="addContactUrl" value="/ajaxAddContact"/>
    <c:url var="removeContactUrl" value="/ajaxRemoveContact"/>
    <c:url var="getContacstUrl" value="/ajaxGetContact"/>
    <c:url var="getMessageUrl" value="/ajaxGetMessage"/>
    <c:url var="sendMessageUrl" value="/ajaxSendMessage"/>
    <script type="text/javascript">//<![CDATA[
       	var myId = ${myId};
                                              
		function getContact(){
			$.getJSON('${getContacstUrl}', {}, function(data){ 
				$('#contact-list').html('');
				
				$(data).each(function(k, v){
					icon = (v.online)? 'icon-comment' :  'icon-minus-sign';
					
					$('#contact-list').append($('<li><a href="javascript:show('+v.idUser+', \''+v.email+'\');" data-id="'+v.idUser+'">'+v.email+' <i class="'+icon+' pull-right"></i></a></li>'));
				});
			});
			
			setTimeout('getContact()', 5000);
		}
		
		function getMessage(){
			$.getJSON(
				'${getMessageUrl}',
				{},
				function(data){ 
					$(data).each(function(k, v){
						if(typeof $('#tab-'+v.idUser).attr('id') == 'undefined'){
							$('#tabs').append($('<li data-id="'+v.idUser+'" id="tab-'+v.idUser+'"><a href="#content-'+v.idUser+'" data-toggle="tab">'+v.email+'</a></li>'));
						}
						if(typeof $('#content-'+v.idUser).attr('id') == 'undefined'){
							$('#tchat .tab-content').append($('<div class="tab-pane" data-id="'+v.idUser+'" id="content-'+v.idUser+'"></div>'));
						}
						
						$('#tab-'+v.idUser+' a').fadeIn().fadeOut().fadeIn().fadeOut().fadeIn().fadeOut().fadeIn().fadeOut().fadeIn().fadeOut().fadeIn();
						
						$(v.messages).each(function(i, j){
							$('#content-'+v.idUser).append('<blockquote><h4>'+((j.to == myId)? v.email : 'ME')+':</h4>'+j.content+'<small class="pull-right">'+j.send+'</small></blockquote>');
						});
					});
				}
			);
			
			setTimeout('getMessage()', 3000);
		}
                     
	function show(id, email){
		if(typeof $('#tab-'+id).attr('id') == 'undefined'){
			$('#tabs').append($('<li data-id="'+id+'" id="tab-'+id+'" class="active"><a href="#content-'+id+'" data-toggle="tab">'+email+'</a></li>'));
		}
		if(typeof $('#content-'+id).attr('id') == 'undefined'){
			$('#tchat .tab-content').append($('<div class="tab-pane active" data-id="'+id+'" id="content-'+id+'"></div>'));
		}
		
		$('#tabs .active').removeClass('active');
		$('#tchat .tab-content .active').removeClass('active');
		$('#content-'+id).addClass('active');
		$('#tab-'+id).addClass('active');
		
	}
                                              
	$(document).ready(function(){
		getContact();
		getMessage();
		
		$('#remove-contact').click(function(){
			$('#select-remove-contact').html('');
			
			$('#contact-list a').each(function(k, v){
				$('#select-remove-contact').append('<option value="'+$(v).data('id')+'">'+$(v).html()+'</option>');
			});
			
			$('#modal-add-remove').modal();
		});
		
		$('#remove').click(function (){
			$.getJSON('${removeContactUrl}', { id : $('#select-remove-contact option:selected').val() }).complete(function() { $('#modal-remove-contact').modal('hide'); });
		});
		
		$('#send').click(function(){
			if(typeof $('#tabs .active').attr('id') == 'undefined'){
				alert('Please choose a contact');
			}
			else if($('#message').val().trim().length < 1){
				alert('Please enter a message');
			}
			else{
				$('#content-'+$('#tabs .active').data('id')).append('<blockquote><h4>ME:</h4>'+$('#message').val().trim()+'</blockquote>');
				$.getJSON(
					'${sendMessageUrl}',
					{id : $('#tabs .active').data('id'), message : $('#message').val().trim()}
				).complete(function() { $('#message').val(''); });
			}
		});
		
		var content = [];
		
		$('#add-contact').click(function(){
			$('#modal-add-contact').modal();
		});
		
		$('#input-add-contact').typeahead({
			source : function(query, process){
				return $.getJSON(
					'${autoCompleteUrl}',
					{begin : query},
					function(data){ 
						content = [];
						show = [];
						$(data).each(function(index){
							show.push(data[index].email);
							content.push({email: data[index].email, id: data[index].idUser});
						});
						return process(show); 
					}
				).complete();
			},
			updater : function(obj){
				id = 0;
				$(content).each(function(i){
					if(content[i].email == obj){
						id = content[i].id;
					}
				});
				$.getJSON('${addContactUrl}', {id : id}).complete(function() { $('#modal-add-contact').modal('hide'); });
			}
		});
	});
	//]]></script>
</body>
</html>