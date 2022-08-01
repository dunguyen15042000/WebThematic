<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>
<c:url var="loginURL" value="/dang-nhap"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Quên mật khấu</title>

</head>
<body>
WHY SHOW IT HERE??
	<!--FORGOT PASSWORD  -->
<div id="forgot-box" class="forgot-box visible widget-box no-border">
WHY SHOW IT HERE??
	<div class="widget-body">
		<div class="widget-main">
			<h4 class="header red lighter bigger">
				<i class="ace-icon fa fa-key"></i> Khôi phục mật khẩu
			</h4>

			<div class="space-6"></div>
			<p>Nhập vào địa chỉ email và chờ thông báo</p>

			<form>
				<fieldset>
					<label class="block clearfix"> 
						<span class="block input-icon input-icon-right"> 
							<input type="email" class="form-control" placeholder="Email" /> 
							<i class="ace-icon fa fa-envelope"></i>
						</span>
					</label>

					<div class="clearfix">
					<a href="<c:url value ='dang-nhap/quen-mat-khau' />" class="back-to-login-link">	<!--data-target="#login-box"   -->
						<button type="submit" class="width-35 pull-right btn btn-sm btn-danger">
							<i class="ace-icon fa fa-lightbulb-o"></i> 
							<span class="bigger-110">Gửi đi!</span>
						</button>
					</a>
					</div>
				</fieldset>
			</form>
		</div>
		<!-- /.widget-main -->

		<div class="toolbar center">
			<a href="${loginURL}" class="back-to-login-link">	<!--data-target="#login-box"  -->
				Trở về đăng nhập 
				<i class="ace-icon fa fa-arrow-right"></i>
			</a>
		</div>
	</div>
	<!-- /.widget-body -->
</div>
<!-- /.forgot-box -->
<!--/FORGOT PASSWORD  -->



</body>
</html>