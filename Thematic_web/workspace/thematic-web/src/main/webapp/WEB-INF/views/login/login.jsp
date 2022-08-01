<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Đăng nhập</title>

</head>
<body>
<div id="login-box" class="login-box visible widget-box no-border">
		<div class="widget-body">
			<div class="widget-main">
				<h4 class="header blue lighter bigger">
					<i class="ace-icon fa fa-coffee green"></i> Điền thông tin để truy cập
				</h4>

				<div class="space-6"></div>

				<!--LOGIN  -->
				<form action="j_spring_security_check" id="formLogin" method="post">
					<fieldset>
						<label class="block clearfix"> 
							<span class="block input-icon input-icon-right"> 
								<input type="text" class="form-control" placeholder="Tài khoản" id="userName" name="j_username" /> 
								<i class="ace-icon fa fa-user"></i>
							</span>
						</label> 
						<label class="block clearfix"> 
							<span class="block input-icon input-icon-right"> 
								<input type="password" class="form-control" placeholder="Mật khẩu" 
								id="password" name="j_password" onchange="encodePassword(this.value)"/> 
								<i class="ace-icon fa fa-lock"></i>
							</span>
						</label>

						<div class="space"></div>

						<div class="clearfix">
							<label class="inline"> 
								<input type="checkbox" class="ace" />
								<span class="lbl"> Ghi nhớ truy cập</span>
							</label> 
							<input type="hidden" value="login" id="action" name="action" />
							<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
								<i class="ace-icon fa fa-key"></i> 
								<span class="bigger-110">Đăng nhập</span>
							</button>
						</div>

						<div class="space-4"></div>
					</fieldset>
				</form>
				<!-- /FORM LOGIN -->
				<div class="social-or-login center">
					<span class="bigger-110">Hoặc đăng nhập với</span>
				</div>

				<div class="space-6"></div>

				<div class="social-login center">
					<a class="btn btn-primary">
						<i class="ace-icon fa fa-facebook"></i>
					</a>
					<a class="btn btn-info">
						<i class="ace-icon fa fa-twitter"></i>
					</a>
					<a class="btn btn-danger"> 
						<i class="ace-icon fa fa-google-plus"></i>
					</a>
				</div>
			</div>

			<div class="toolbar clearfix">
				<div>
					<a href="<c:url value='/dang-nhap/quen-mat-khau' />" class="forgot-password-link"> 
						<i class="ace-icon fa fa-arrow-left"></i> Quên mật khẩu
					</a>
				</div>
				<div>
					<a href="<c:url value='/dang-nhap/dang-ky' />" class="user-signup-link">	
						Đăng ký <i class="ace-icon fa fa-arrow-right"></i>
					</a>
				</div>
			</div>
		</div>
	</div>

<script>
	function encodePassword(val) {
		fetch("/api/encode", {
			method: 'POST',
			body: JSON.stringify({
					"password": val,
			}),
			headers: {
				"Content-Type": "application/json"
			}
		}).then(function(res) {
			return res.json()
		}).then(function(userDTO){
			$('#password').val(userDTO.password);
		});
	}
</script>
</body>
</html>
