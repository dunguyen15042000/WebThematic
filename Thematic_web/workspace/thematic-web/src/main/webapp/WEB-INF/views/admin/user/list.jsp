<%@include file="/common/taglib.jsp"%>
<c:url var="userAPI" value="/api/user"/>
<c:url var="userURL" value="/quan-tri/nguoi-dung/danh-sach"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách người dùng</title>
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
						<li class="active">Người dùng</li>
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
		<form action="<c:url value='/quan-tri/nguoi-dung/danh-sach'/>" id="formSubmit" method="get">

			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<div class="row">
				<div class="col-xs-12">
					<h3 class="header smaller lighter blue">Danh sách người dùng</h3>

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
										<i class="ace-icon fa fa-file-o bigger-110 hidden-480"></i>Tên người dùng</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Tài khoản</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Mật khẩu</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Trạng thái</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Email</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Vai trò</th>
										
									<th class="hidden-sm hidden-xs action-buttons">
										<c:url var="createUserURL" value="/quan-tri/nguoi-dung/chinh-sua"/>
										<a class="green" href='${createUserURL}' title="Thêm người dùng">
										 	<i class="ace-icon fa fa-plus bigger-130"></i>
										</a>	
										<button type="button" class="red" style="border:none !important; background:none !important"  
										id="btnDeleteAll" onclick="warningBeforeDeleteAll()" title="Xóa người dùng"> 
											<i class="ace-icon fa fa-trash-o bigger-130"></i>
										</button>
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
										<td>${item.fullName}</td>
										<td>${item.username}</td>
										<td>${item.password}</td>
										<td>${item.status}</td>
										<td>${item.email}</td>
										<td>
											<c:forEach var="role" items="${item.listRole}">
												${role.name},
											</c:forEach>
											
										</td>
									<%-- 	<td>${item.roles}</td> --%>
										<td>
											<div class="hidden-sm hidden-xs action-buttons">
													
													<c:url var="updateUserURL" value="/quan-tri/nguoi-dung/chinh-sua">
														<c:param name="id" value="${item.id}"/>															
													</c:url>
													<a class="blue" title="Cập nhật người dùng" href='${updateUserURL}'>
														<i class="ace-icon fa fa-pencil bigger-130"></i>
													</a>
													
													<button type="button" class="red" style="border:none !important; background:none !important"
													  id="btnDelete" onclick="warningBeforeDelete()" title="Xóa người dùng"> 
														<i class="ace-icon fa fa-trash-o bigger-130"></i>
													</button>
											</div>
										</td>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>

<script>
	function warningBeforeDelete() {
		swal({
		  title: "Xác nhận thay đổi",
		  text: "Bạn có muốn trạng thái người dùng thay đổi không?",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonClass: "btn-primary",
		  cancelButtonClass: "btn-danger",
		  confirmButtonText: "Xác nhận",
		  cancelButtonText: "Hủy bỏ",
		}).then(function(isConfirm) {
		  if (isConfirm) {
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
				console.log(ids);
				deleteUser(ids);
		  }
		});
	}
	
	function deleteUser(data) {
		$.ajax({
		     url: '${userAPI}',
		     type: 'DELETE',
		     contentType: 'application/json',
		     data: JSON.stringify(data),
		     success: function (result) {
		    	 console.log(result);
		         /* window.location.href = "${userURL}?&message=delete_success"; */
		         window.location.href = "${userURL}?&message=update_status_success";
		     },
		     error: function (error) {
		    	 console.log(result);
		     	window.location.href = "${userURL}?&message=error_system";
		     }
		});
	}
	
	function warningBeforeDeleteAll() {
	swal({
	  title: "Xác nhận xóa",
	  text: "Bạn có chắc chắn muốn xóa hay không?",
	  type: "warning",
	  showCancelButton: true,
	  confirmButtonClass: "btn-success",
	  cancelButtonClass: "btn-danger",
	  confirmButtonText: "Xác nhận",
	  cancelButtonText: "Hủy bỏ",
	}).then(function(isConfirm) {
	  if (isConfirm) {
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
	            return $(this).val();
	        }).get();
			deleteUser(ids);
	  }
	});
	} 
</script>
</body>
</html>