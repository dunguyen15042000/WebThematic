<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- MENU -->
			<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

					
				<ul class="nav nav-list">
					<li class="active open">
						<a href='<c:url value ="/quan-tri/trang-chu"/>'>
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Trang chủ </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="open ">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> Quản lý 
								<span class="badge badge-primary">5</span>
							</span>
						
							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="<c:url value= '/quan-tri/bai-viet/danh-sach' />">
									<i class="menu-icon fa fa-caret-right"></i>
										Bài biết
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="<c:url value= '/quan-tri/the-loai/danh-sach' />">
									<i class="menu-icon fa fa-caret-right"></i>
										Thể loại
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="<c:url value= '/quan-tri/binh-luan/danh-sach' />">
									<i class="menu-icon fa fa-caret-right"></i>
										Bình luận
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="<c:url value= '/quan-tri/gio-hang/danh-sach' />">
									<i class="menu-icon fa fa-caret-right"></i>
										Giỏ hàng
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="<c:url value= '/quan-tri/vai-tro/danh-sach' />">
									<i class="menu-icon fa fa-caret-right"></i>
										Vai trò
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="<c:url value= '/quan-tri/nguoi-dung/danh-sach' />">
									<i class="menu-icon fa fa-caret-right"></i>
										Người dùng
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-file-o"></i>
							<span class="menu-text">
								Khác
								<span class="badge badge-primary">3</span>
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						<ul class="submenu">
							<li class="">
								<a href='<c:url value='/quan-tri/error-404' />'  >
									<i class="menu-icon fa fa-caret-right"></i>
									Error 404
								</a>
								<b class="arrow"></b>
							</li>
							<li class="">
								<a href='<c:url value='/quan-tri/error-500' />'>
									<i class="menu-icon fa fa-caret-right"></i>
									Error 500
								</a>
								<b class="arrow"></b>
							</li>
							<li class="">
								<a href='<c:url value ='/quan-tri/blank-page'/>' >
									<i class="menu-icon fa fa-caret-right"></i>
									Blank Page
								</a>
								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					<li class="">
						<a href='<c:url value ="/quan-tri/ho-so"/>'>
							<i class="menu-icon fa fa-user"></i>
							<span class="menu-text"> Hồ sơ </span>
						</a>

						<b class="arrow"></b>
					</li>
					
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>
			<!-- /MENU -->