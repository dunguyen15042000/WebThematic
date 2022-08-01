<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="commentAPI" value="/api/web/comment"/>
<c:url var="shopitemURL" value="/bai-viet"/>
<!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->

<link rel="stylesheet" href="<c:url value='/template/web/comment/style.css' />"> 


	<%-- <form action="<c:url value='/binh-luan'/>" id="formSubmit" method="get"> --%>
		<div class="body container px-4 px-lg-5">
			<div class="row bootstrap snippets bootdeys">
		    	<div class="col-sm-12">
		        	<div class="comment-wrapper">
		            	<div class="panel panel-info">
		                <div class="panel-heading my-3">
		                		<h4 class="text-success" >Bình luận(</h4>$(comments.listResult.size())<h4 class="text-success">):</h4> 
		                </div>
		                <c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<%-- <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">		 --%>
			                <div class="panel-body">
			                	<input type="hidden" value="${news.id}" id="newsId" />
			                    <textarea class="form-control"
			                    rows="4" id="commentContent" placeholder="write a comment..."></textarea>
			                    
			                    <br>
			                    <%-- <form:hidden path="id" id="commentId" /> --%>
			                    <button type="button" class="btn btn-info pull-right" id="btnSend" onclick="addComment()">Gửi</button>
			                    
			                    <div class="clearfix"></div>
			                    <hr>
			                    <ul class="media-list ">
			                    	<c:forEach var="item" items="${comments.listResult}">
			                        <li class="media pt-2 comments bg-white">
			                            <a href="#" class="pull-left">
			                                <img src="https://bootdey.com/img/Content/user_1.jpg" alt="" class="img-circle">
			                            </a>
			                            <div class="media-body">
			                                <span class="text-muted pull-right">
			                                    <small class="text-muted">$(item.createdDate)</small>
			                                </span>
			                                <strong class="text-success">$(item.createdBy)</strong>
			                                <p>- $(item.content)</p>
			                            </div>
			                        </li>
			                        </c:forEach>
			                    </ul>
			                   <div class="bg-primary text-center text-white white py-2" id="btnLoadComment">Xem thêm</div>
			                </div>
			  <%--           </form:form> --%>
		            	</div> 
		       		</div>
		   		</div>
			</div>
		</div>
<!-- 	</form> -->
