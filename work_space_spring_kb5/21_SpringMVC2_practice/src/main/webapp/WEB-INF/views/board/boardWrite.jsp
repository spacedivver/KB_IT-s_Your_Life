<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 작성" name="title"/>
</jsp:include>

<!-- 글쓰기 에디터 추천 : https://summernote.org/ , https://naver.github.io/smarteditor2/user_guide/ -->

<section id="board-write-container">
	<h2 align="center">게시글 작성</h2>
	
	<!-- enctype="multipart/form-data" : 파일 첨부를 할수 있는 html 옵션  -->

</section>



<jsp:include page="/WEB-INF/views/common/footer.jsp"/>







