<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách giỏ hàng</title>
</head>

<body>
	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chủ</a>
						</li>

				 		<li><a href="#">Quản lý</a></li>
						<li class="active">Giỏ hàng</li>
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
		<form action="<c:url value='/quan-tri/gio-hang/danh-sach'/>" id="formSubmit" method="get">

			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<div class="row">
				<div class="col-xs-12">
					<h3 class="header smaller lighter blue">Danh sách giỏ hàng</h3>

					<div class="clearfix">
						<div class="pull-right tableTools-container"></div>
					</div>
					<div class="table-header">Results for "Latest Registered Domains"</div>
					<div>
						<table id="dynamic-table"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center">
										<label class="pos-rel"> 
											<input type="checkbox" class="ace" />
											<span class="lbl"></span>
										</label>
									</th>
									<!--<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">Domain</th>  -->
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-file-o bigger-110 hidden-480"></i>Người dùng</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Bài viết</th>
									<th class="hidden-sm hidden-xs action-buttons">
									</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td class="center">
											<label class="pos-rel">
												<input type="checkbox" class="ace" id="checkbox_${item.id}"
												value="${item.id}" /> 
													<span class="lbl"></span>
											</label>
										</td>

										<td>${item.userName}</td>
										<td>
											<c:forEach var="news" items="${item.listNews}">
												${news.title}, 
											</c:forEach>
										</td>
										<td>
											<div class="hidden-sm hidden-xs action-buttons">
											</div>
	
												<div class="hidden-md hidden-lg">
													<div class="inline pos-rel">
														<button class="btn btn-minier btn-yellow dropdown-toggle"
															data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
														</button>
	
														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="View"> <span class="blue">
																		<i class="ace-icon fa fa-search-plus bigger-120"></i>
																</span>
															</a></li>
	
															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="Edit"> <span class="green">
																		<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																</span>
															</a></li>
	
															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="Delete"> <span class="red">
																		<i class="ace-icon fa fa-trash-o bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
												</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
<script>
	 
	 
	 
</script>
</body>
</html>