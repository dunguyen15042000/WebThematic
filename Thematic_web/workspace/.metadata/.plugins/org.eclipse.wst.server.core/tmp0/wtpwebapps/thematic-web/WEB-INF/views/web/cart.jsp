<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- Modal -->
	<%-- <form:form method="POST" action="" modelAttribute="model"> --%>
        <div class="modal fade" id="exampleModalLong" role="dialog" aria-labelledby="exampleModalLongTitle" 
        aria-hidden="true" style="padding-right: 0px !impotant" >
          <div class="modal-dialog" style="width: 1000px !impotant">
            <div class="modal-content" style="width: 1000px !impotant">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">DS Xem sau</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <table class="table table-striped table-hover" >
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col" style="width: 25%">ID bài viết</th>
                      <th scope="col" style="width: 30%">Tên bài viết</th>
                      <th scope="col" style="width: 25%">ID thể loại</th>
                     <!--  <th scope="col">Số lượng</th> -->
                    </tr>
                  </thead>
                  <tbody>
                 	<c:forEach var="item" items="${cart.listNews}">
	                    <tr class="news">
	                      <td class="center">
							<label class="pos-rel">
								<input type="checkbox" class="ace" id="checkbox_${item.id}" value="${item.id}" /> 
									<span class="lbl"></span>
							</label>
						  </td>
	                      <td>${item.id}</td>
	                      <td>${item.title}</td>
	                      <td>${item.categoryCode}
	                   <!--    <td>1</td> -->
	                      <td style="width: 30%">
	                      	<a href="<c:url value='/bai-viet?id=${item.id}' />">
	                      		<button class="btn btn-primary" title="Xem bài viết">Xem</button>
	                      	</a>
	                      </td>
	                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
                <c:if test="${cart.listNews.size() >0}">
				 	<button type="button" class="btn btn-primary mb-3" id="btnMore" >Xem thêm</button> 
				</c:if>
				 <c:if test="${cart.listNews.size() ==0}">
				 	<small class=""><i>Không có bài viết nào trong danh sách</i></small>
				</c:if>
               	 
                
              </div>
              <div class="modal-footer">
              	<button class="btn btn-danger" type="button" id="btnDelete" onclick="warningBeforeDelete()" 
	             title="Xóa bài viết" disabled>Xóa </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
              </div>
            </div>
          </div>
        </div>
<%-- 	</form:form>     --%>    

<script>

$('tbody input[type=checkbox]').change(function() {
  	 if (this.checked) {
  		$('#btnDelete').removeAttr('disabled');
  	 } else {
  		$('#btnDelete').attr('disabled','disabled');
  	 }
});


</script>
        