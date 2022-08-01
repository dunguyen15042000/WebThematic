<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua"/>
<c:url var="newAPI" value="/api/new"/>

<html>
<head>
<title>Thay đổi bài viết</title>
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
					<li class="active">Chỉnh sửa bài viết</li>
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
						
						<form:form action=''  class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
							<div class="form-group">
								<label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại:</label>
								<div class="col-sm-9">
									<form:select path="categoryCode" id="categoryCode">
										<form:option value="" label="-- Chọn thể loại --" />
										<form:options items="${categories}" />
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên bài viết</label>
								<div class="col-sm-9">
									<form:input path="title" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<!--LOAD IMG  -->
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Ảnh đại diện</label>
								<div class="col-sm-9">
									<form:input type="file" path="thumbnail" id="thumbnail" accept="image/gif, image/png, image/jpg" 
									class="col-xs-10 col-sm-5" onchange="chooseFile(event)"  />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>
									<!-- <img src=""  alt="" id="image" style=""  class="col-xs-10 col-sm-5"  /> -->
									<img id="image" src="${model.thumbnail}"  />
								</div> 
							</div>	
							<!--/LOAD IMG  -->
							<div class="form-group">
								<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả ngắn:</label>
								<div class="col-sm-9">
									<form:textarea path="shortDescription" rows="5" cols="10" cssClass="form-control" id="shortDescription" />
								</div>
							</div>
							<div class="form-group">
								<label for="content"
									class="col-sm-3 control-label no-padding-right">Nội dung:</label>
								<div class="col-sm-9">
									<form:textarea path="content" rows="5" cols="10" cssClass="form-control" id="content" />
								</div>
							</div>
							
							<form:hidden path="id" id="newId" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài viết
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
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
	/* var file = document.getElementById('thumbnail').files[0];	  */
	var thumbnail;
	
	function chooseFile(evt){
		evt.stopPropagation();
		evt.preventDefault();
		
		var files = evt.target.files;
	    var file = files[0];
	    var fileReader = new FileReader();
	    
	    fileReader.onload = function(progressEvent) {
	    	$('#image').attr('src', progressEvent.target.result); 
	        var stringData = fileReader.result;
	        thumbnail = stringData;
	    }
	    fileReader.readAsDataURL(file); // fileReader.result -> BASE-64
	    /*fileReader.readAsBinaryString(file);  */
	}
		
	/*get data from CKEditor  */
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace('content');
	});		
	
	/*action event from button  */
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();	
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	   	data["thumbnail"] = thumbnail; 
	    data["content"] = editor.getData();
	    var id = $('#newId').val();
	    if (id == "") {
	    /* 	console.log('thumbnail: '+data['thumbnail']); */
	    	 addNew(data);
	    } else {
	    	if(typeof(thumbnail) =='undefined'){
	    		data["thumbnail"] = document.getElementById("image").getAttribute("src");
	    	}
	    	updateNew(data);
	    }
	});
	
	
	function addNew(data) {
		$.ajax({
			url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {		//result = NewDTO (là kq trả về của các API)
            	window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${newURL}?message=error_system";
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
            }
        });
	}

</script>	
</body>
</html>
