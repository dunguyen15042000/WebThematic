<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Thể loại</title>

</head>

<body>

	<%-- <%@ include file="/WEB-INF/views/web/cart.jsp" %> --%>

	<!--BODY CONTENT  -->
	<nav aria-label="breadcrumb " class="breadcrumb py-0 container" style="background: none !important">
                <ol class="breadcrumb mb-0 container px-2 px-lg-5 " style="background: none !important">
                    <li class="breadcrumb-item">
                    	<a href="<c:url value='/trang-chu' />" style="color: white">
                    	</a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                    	<a href="<c:url value='/the-loai?categoryCode=${category.code}' /> " style="color: white"><u>Thể loại-${category.id}</u></a>
                    </li>
                    <li class="breadcrumb-item">...</li>
                </ol>
     </nav>
     
	 <!-- Section-->
        <section class="">
            <div class="container px-2 px-lg-5 mt-4">
                <!-- Card item -->
                <!--forEach  -->
                <c:forEach var="item" items="${news.listResult}">
	                <div class="card h-100 mb-2 product">
	                    <div class="row gx-4 gx-lg-5 justify-content-center">
	                        <div class="col col-4 ">
	                         <!--    <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" />  -->
	                            <img class="card-img-top" src="${item.thumbnail}" style="height:250px;"/> 
	                    	</div>
		                    <div class="col col-8 ">
		                        <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">${item.title}</h5>
		                                    <!-- Product price-->
		                                    ${item.shortDescription}
		                                </div>
		                         </div>
		                            <!-- Product actions-->
		                         <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                         	<div class="text-center">
			                         	<a class="btn btn-outline-dark mt-auto" href="<c:url value='/bai-viet?id=${item.id}' />">
			                         		Xem bài viết
			                         	</a>
		                         	</div>
		                         </div>
		                         <div class="float-right">
		                         	<small>Thể loại: ${item.categoryCode}</small>
		                         	<div class="d-flex">
		                         		<small>${item.createdDate}</small><small> -By: ${item.createdBy}</small>
		                         	</div>
		                         </div>
		                          <div class="float-left" >
		                            <button class="btn btn-outline-dark py-0" type="button" onclick="addToCart(${item.id})">
		                                <small>+<i class="bi-cart-fill me-1"></i></small>
		                                <small>Xem sau</small>
		                            </button>
                        		</div>
		                    </div>
	                    </div>
	                </div>
                </c:forEach>
                
                <button type="button" class="btn btn-primary mb-3" id="btnLoadMore">Xem thêm</button> 
            </div>
        </section>
</body>
</html>