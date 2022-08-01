<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title><dec:title default="Đăng nhập" /></title>
<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


<link rel="stylesheet" href="/template/login/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="/template/login/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="/template/login/assets/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" href="/template/login/assets/css/ace.min.css" />
<link rel="stylesheet" href="/template/login/assets/css/ace-rtl.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body class="login-layout" id="LoginForm">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">FOOTBALL</span> <span class="white" id="id-text2">For us</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy;Edu.hcmuaf-Information Technology</h4>
						</div>

						<div class="space-6"></div>

						<!--alert  -->
						<c:if test="${param.incorrectAccount != null }">
							<div class="alert alert-danger">Username or password
								incorrect!</div>
						</c:if>
						<c:if test="${param.accessDenied != null }">
							<div class="alert alert-danger">You not Authorize!</div>
						</c:if>
						
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}
							</div>
						</c:if>

						<div class="position-relative"></div>

						<!--BODY  -->
						<dec:body />
						<!--/BODY  -->

						<%-- <%@ include file="/common/login/forgotPassword.jsp"%>
						<%@ include file="/common/login/register.jsp"%> --%> 
					</div>
					<div class="navbar-fixed-top align-right">
						<br /> 
						&nbsp; 
						<a id="btn-login-dark" href="#">Dark</a> 
						&nbsp; 
						<span class="blue">/</span>
						 &nbsp; 
						<a id="btn-login-blur" href="#">Blur</a>
						&nbsp;
						<span class="blue">/</span>
						  &nbsp; 
						<a id="btn-login-light" href="#">Light</a> 
						&nbsp; &nbsp; &nbsp;
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	
	
	<script
		src="<c:url value='/template/login/assets/js/jquery.2.1.1.min.js'/>"></script>
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='/template/login/assets/js/jquery.min.js'>"
								+ "<"+"/script>");
	</script>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='/template/login/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	/* 	jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		}); */

		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
	</script>
</body>
</html>