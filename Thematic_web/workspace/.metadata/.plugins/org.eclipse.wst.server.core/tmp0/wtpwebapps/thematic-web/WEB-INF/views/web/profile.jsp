<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="profileURL" value="/ho-so"/>
<c:url var="profileAPI" value="/api/web/user"/>
<%@ page import="edu.hcmuaf.util.SecurityUtils"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Hồ sơ người dùng</title>


</head>
<body>
	<div class="container-xl px-4 mt-4">
    <!-- Account page navigation-->
    <nav aria-label="breadcrumb " class="breadcrumb py-0 container" style="background: none !important">
                <ol class="breadcrumb mb-0 container px-2 px-lg-5 " style="background: none !important">
                    <li class="breadcrumb-item">
                    	<a href="<c:url value='/trang-chu' />" style="color: white">
                    		<u>Trang chủ</u>
                    	</a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                    	<a href="<c:url value='/ho-so' /> " style="color: white"><u>Hồ sơ</u></a>
                    </li>
                    <li class="breadcrumb-item">...</li>
                </ol>
     </nav>
     
    <hr class="mt-0 mb-4">
    <div class="row">
    	<c:if test="${not empty message}">
			<div class="alert alert-${alert}">${message}</div>
		</c:if>
        <div class="col-xl-4">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">Ảnh đại diện</div>
                <div class="card-body text-center">
                    <!-- Profile picture image-->
                    <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                    <!-- Profile picture help block-->
                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                    <!-- Profile picture upload button-->
                    <button class="btn btn-primary" type="button" disabled>Cập nhật ảnh mới</button>
                </div>
            </div>
        </div>
        <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">Chi tiết cá nhân</div>
                <div class="card-body">
                    <form:form action='' class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data"> 
                        <!-- Form Group (username)-->
                        <div class="mb-3">
                            <label class="small mb-1" >Tài khoản</label>
                            <input class="form-control" value="<%=SecurityUtils.getPrincipal().getUsername()%>" disabled/>
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" >Mật khẩu</label>
                            <input class="form-control" value="*************" disabled/>
                        </div>
                        <!-- Form Row-->
                        <div class="mb-3">
                            <label class="small mb-1" >Họ và tên</label>
                    		<form:input path="fullName" cssClass="form-control" />
                        </div>
                        <!-- Form Group (email address)-->
                        <div class="mb-3">
                            <label class="small mb-1" >Email</label>
                            <form:input path="email" cssClass="form-control"/>
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" >Giới tính</label>
                                <form:input path="sex" cssClass="form-control" />
                            </div>
                            <!-- Form Group (birthday)-->
                            <div class="col-md-6">
                                <label class="small mb-1" >Trạng thái</label>
                            	<input  disabled class="form-control" value="Đang hoạt động"/>
                            </div>
                        </div>
                        <form:hidden path="id" id="userId" />
                        <!-- Save changes button-->
                        <button class="btn btn-primary" type="button" id="btnSave">Lưu thay đổi</button>
                  </form:form> 
                </div>
            </div>
        </div>
    </div>
	</div>



<script>
/*action event from button  */
var id = $('#userId').val();
$('#btnSave').click(function (e) {
    e.preventDefault();	
    var data = {};
    var formData = $('#formSubmit').serializeArray();
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });
    var id = $('#userId').val();
    if (id == "") {
    	alert("user id is empty !!!");
    	/*  addUser(data); */
    } else {
    	updateUser(data);
    }
});


function updateUser(data) {
	$.ajax({
        url: '${profileAPI}',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
        	window.location.href = "${profileURL}?id="+result.id+"&message=update_success";
        },
        error: function (error) {
        	window.location.href = "${profileURL}?id="+id+"&message=error_system";
        }
    });
}


</script>
</body>
</html>