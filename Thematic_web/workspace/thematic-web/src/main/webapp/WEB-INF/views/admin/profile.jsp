<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NewURL" value="/admin-new" />
<%@ page import="edu.hcmuaf.util.SecurityUtils"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Hồ sơ cá nhân</title>
</head>

<body>
	<!-- BODY -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href='<c:url value='/quan-tri/trang-chu' />'>Trang chủ</a></li>

					<!-- <li><a href="#">Khác</a></li> -->
					<li class="active">Hồ sơ người dùng</li>
				</ul>
				<!-- /.breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<!-- <span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
						</span> -->
					</form>
				</div>
			</div>

			<div class="tab-content no-border padding-24">
				<div id="home" class="tab-pane in active">
					<div class="row">
						<div class="col-xs-12 col-sm-3 center">
							<span class="profile-picture"> <img
								class="editable img-responsive" alt="Alex's Avatar" id="avatar2"
								src="assets/avatars/profile-pic.jpg" />
							</span>

							<div class="space space-4"></div>

							<a href="#" class="btn btn-sm btn-block btn-success"> <i
								class="ace-icon fa fa-plus-circle bigger-120"></i> <span
								class="bigger-110">Add as a friend</span>
							</a> <a href="#" class="btn btn-sm btn-block btn-primary"> <i
								class="ace-icon fa fa-envelope-o bigger-110"></i> <span
								class="bigger-110">Send a message</span>
							</a>
						</div>

						<div class="col-xs-12 col-sm-9">
							<h4 class="blue">
								<span class="middle"> <%=SecurityUtils.getPrincipal().getFullName()%>
								</span>
								<span class="label label-purple arrowed-in-right">
								 	 <i class="ace-icon fa fa-circle smaller-80 align-middle"></i>
									online
								</span>
							</h4>

							<div class="profile-user-info">
								<div class="profile-info-row">
									<div class="profile-info-name">Tên: </div>

									<div class="profile-info-value">
										<span><%=SecurityUtils.getPrincipal().getFullName()%> </span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Quốc tịch: </div>

									<div class="profile-info-value">
										<i class="fa fa-map-marker light-orange bigger-110"></i> <span>HCM </span>
										<span>Vietnam</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Tài khoản: </div>

									<div class="profile-info-value">
										<span><%=SecurityUtils.getPrincipal().getUsername()%></span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Mật khẩu: </div>

									<div class="profile-info-value">
										<span>*************</span>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">Trạng thái: </div>

									<div class="profile-info-value">
								 	 		<i class="ace-icon fa fa-circle smaller-80 align-middle" style="color: #6de66d !important"></i>
												online
									</div>
								</div>
							</div>

							<div class="hr hr-8 dotted"></div>

							<div class="profile-user-info">
								<div class="profile-info-row">
									<div class="profile-info-name">Website</div>

									<div class="profile-info-value">
										<a href="#" target="_blank">www.18130044-hcmuaf.com</a>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">
										<i
											class="middle ace-icon fa fa-facebook-square bigger-150 blue"></i>
									</div>

									<div class="profile-info-value">
										<a href="https://www.facebook.com/">Liên hệ qua Facebook</a>
									</div>
								</div>

								<div class="profile-info-row">
									<div class="profile-info-name">
										<i
											class="middle ace-icon fa fa-twitter-square bigger-150 light-blue"></i>
									</div>

									<div class="profile-info-value">
										<a href="https://twitter.com/">Liên hệ qua Twitter</a>
									</div>
								</div>
							</div>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->

					<div class="space-20"></div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-small">
									<h4 class="widget-title smaller">
										<i class="ace-icon fa fa-check-square-o bigger-110"></i>
										Little About Me
									</h4>
								</div>

								<div class="widget-body">
									<div class="widget-main">
										<p>My job is mostly lorem ipsuming and dolor sit ameting
											as long as consectetur adipiscing elit.</p>
										<p>Sometimes quisque commodo massa gets in the way and sed
											ipsum porttitor facilisis.</p>
										<p>The best thing about my job is that vestibulum id
											ligula porta felis euismod and nullam quis risus eget urna
											mollis ornare.</p>
										<p>Thanks for visiting my profile.</p>
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6">
							<div class="widget-box transparent">
								<div class="widget-header widget-header-small header-color-blue2">
									<h4 class="widget-title smaller">
										<i class="ace-icon fa fa-lightbulb-o bigger-120"></i> My Skills
									</h4>
								</div>	
								
								<div class="widget-body">
									<div class="widget-main">
										<p>My job is mostly lorem ipsuming and dolor sit ameting
											as long as consectetur adipiscing elit.</p>
										<p>Sometimes quisque commodo massa gets in the way and sed
											ipsum porttitor facilisis.</p>
										<p>The best thing about my job is that vestibulum id
											ligula porta felis euismod and nullam quis risus eget urna
											mollis ornare.</p>
										<p>Thanks for visiting my profile.</p>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--/ BODY -->
</body>

</html>