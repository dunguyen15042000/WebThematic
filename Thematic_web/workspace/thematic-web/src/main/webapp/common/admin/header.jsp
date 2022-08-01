<%@ page import="edu.hcmuaf.util.SecurityUtils" %>
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
	<!-- HEADER -->
		<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="<c:url value='/quan-tri/trang-chu' />" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							Quản trị
						</small>  
					</a>
				</div>
				<div class="navbar-header">
					<a href="#" class="navbar-brand">
					<small> - </small>
					</a>
				</div>
				<div class="navbar-header">
					<a href="<c:url value='/trang-chu' />" class="navbar-brand">
						<small>
							<i class="fa fa-futbol-o"></i>
							Trang web
						</small> 
					</a>
				</div>
				
				
				
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<!-- <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" /> -->
								<span class="user-info">
									<small>Xin chào, <%=SecurityUtils.getPrincipal().getFullName()%> 
										<i class="ace-icon fa fa-caret-down"></i>
									</small>
									
								</span>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Thiết lập
									</a>
								</li>

								<li>
									<a href="<c:url value='/quan-tri/ho-so'/>">
										<i class="ace-icon fa fa-user"></i>
										Hồ sơ
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="<c:url value='/thoat'/>">	
										<i class="ace-icon fa fa-power-off"></i>
										Đăng xuất
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>
		<!-- /HEADER -->