<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/quan-tri/nguoi-dung/danh-sach"/>
<c:url var="editUserURL" value="/quan-tri/nguoi-dung/chinh-sua"/>
<c:url var="userAPI" value="/api/user"/>

<html>
<head>
<title>Thay đổi người dùng</title>
</head>
<body>
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
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chủ</a></li>
					<li class="active">Chỉnh sửa nguời dùng</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}
							</div>
						</c:if>
						
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<div class="form-group">
								<label for="roleCode" class="col-sm-3 control-label no-padding-right">Vai trò:</label>
								<div class="col-sm-9" >
									<%-- <form:select path="roleCode" id="roleCode">
										<form:option value="" label="-- Chọn thể loại --" />
										<form:options items="${roles}" />
									</form:select> --%>
									<%-- <form:checkbox path="receiveNewsletter" />  --%>
									<form:checkboxes items="${roles}" path="roleCode" delimiter="	-" id="roleCode"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên người dùng:</label>
								<div class="col-sm-9">
									<form:input path="fullName" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label for="username" class="col-sm-3 control-label no-padding-right">Tài khoản:</label>
								<div class="col-sm-9">
									<form:input path="username" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-3 control-label no-padding-right">Mật khẩu:</label>
								<div class="col-sm-9">
									<form:input path="password" cssClass="col-xs-10 col-sm-5" disabled/>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-3 control-label no-padding-right">Email:</label>
								<div class="col-sm-9">
									<form:input path="email" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label for="status" class="col-sm-3 control-label no-padding-right">Trạng thái:</label>
								<div class="col-sm-9">
									<form:input path="status" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<form:hidden path="id" id="userId" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateUser">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật người dùng
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateUser">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm người dùng
										</button>
									</c:if>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
<script>
	$('#btnAddOrUpdateUser').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#userId').val();
	    if (id == "") {
	    	addUser(data);
	    } else {
	    	updateUser(data);
	    }
	});
	
	function addUser(data) {
		$.ajax({
            url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {		//result = NewDTO (là kq trả về của các API)
            	window.location.href = "${editUserURL}?id="+result.id+"&message=insert_success";
        
            },
            error: function (error) {
            	window.location.href = "$userURL}?message=error_system";
            }
        });
	}
	
	function updateUser(data) {
		$.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editUserURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editUserURL}?id="+result.id+"&message=error_system";
            }
        });
	}

</script>	
</body>
</html>
