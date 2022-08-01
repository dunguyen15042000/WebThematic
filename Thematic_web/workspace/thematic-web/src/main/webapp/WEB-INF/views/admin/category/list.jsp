<%@include file="/common/taglib.jsp"%>
<c:url var="categoryAPI" value="/api/category"/>
<c:url var="categoryURL" value="/quan-tri/the-loai/danh-sach"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách thể loại</title>
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
						<li class="active">Thể loại</li>
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
		<form action="<c:url value='/quan-tri/the-loai/danh-sach'/>" id="formSubmit" method="get">

			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<div class="row">
				<div class="col-xs-12">
					<h3 class="header smaller lighter blue">Danh sách thể loại</h3>

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
										<i class="ace-icon fa fa-file-o bigger-110 hidden-480"></i>Tên thể loại</th>
									<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
										<i class="ace-icon fa fa-book bigger-110 hidden-480"></i>Mã thể loại</th>
									<th class="hidden-sm hidden-xs action-buttons">
										<c:url var="createCategoryURL" value="/quan-tri/the-loai/chinh-sua"/>
										<a class="green" href='${createCategoryURL}' title="Thêm thể loại">
										 	<i class="ace-icon fa fa-plus bigger-130"></i>
										</a>	
										<button type="button" class="red" style="border:none !important; background:none !important"  
										id="btnDeleteAll" onclick="warningBeforeDeleteAll()" title="Xóa thể loại"> 
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
										<td>${item.name}</td>
										<td>${item.code}</td>
										<td>
											<div class="hidden-sm hidden-xs action-buttons">
													
													<c:url var="updateCategoryURL" value="/quan-tri/the-loai/chinh-sua">
														<c:param name="id" value="${item.id}"/>															
													</c:url>
													<a class="blue" title="Cập nhật thể loại" href='${updateCategoryURL}'>
														<i class="ace-icon fa fa-pencil bigger-130"></i>
													</a>
													
													<button type="button" class="red" style="border:none !important; background:none !important"
													  id="btnDelete" onclick="warningBeforeDelete()" title="Xóa bài viết"> 
														<i class="ace-icon fa fa-trash-o bigger-130"></i>
													</button>
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
	
	
	function warningBeforeDelete() {
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
				console.log(ids);
				deleteCategory(ids);
		  }
		});
	}

	function deleteCategory(data) {
		$.ajax({
		     url: '${categoryAPI}',
		     type: 'DELETE',
		     contentType: 'application/json',
		     data: JSON.stringify(data),
		     success: function (result) {
		    	 console.log(result);
		         window.location.href = "${categoryURL}?&message=delete_success";
		     },
		     error: function (error) {
		    	 console.log(result);
		     	window.location.href = "${categoryURL}?&message=error_system";
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
			deleteAllCategory(ids);
	  }
	});
	} 
	function deleteAllCategory(data) {
		$.ajax({
		     url: '${categoryAPI}',
		     type: 'DELETE',
		     contentType: 'application/json',
		     data: JSON.stringify(data),
		     success: function (result) {
		         window.location.href = "${categoryURL}?message=delete_success";
		     },
		     error: function (error) {
		     	window.location.href = "${categoryURL}?&message=error_system";
		     }
		});
	}
	</script>
</body>
</html>