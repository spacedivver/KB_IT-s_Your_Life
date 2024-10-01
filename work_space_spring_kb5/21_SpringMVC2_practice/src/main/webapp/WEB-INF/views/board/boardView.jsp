<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 상세조회" name="title"/>
</jsp:include>

<section id="board-write-container">
	<h2 align="center">게시글 상세조회</h2>
	

	<br>
</section>


<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


<script type="text/javascript">

	$(document).ready(() => {
		$("#btnUpdate").click((e) => {
			location.href = "${path}/board/update?bno=${board.bno}";
		});
		
		$("#btnDelete").click((e) => {
			if(confirm("정말로 게시글을 삭제 하시겠습니까?")) {
				location.replace("${path}/board/delete?bno=${board.bno}");
			}
		});
	});

</script>


















