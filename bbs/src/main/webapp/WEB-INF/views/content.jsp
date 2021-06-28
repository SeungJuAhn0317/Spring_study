<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   글번호 : ${article.articleNum}<br>
    아이디 : ${article.id}<br>
    제목 : ${article.title}<br>
    내용 : ${article.content}<br>
    날짜 : ${article.writeDate}<br><br>
    <hr/>
    
    
    <c:if test="${id !=null}">
       <c:if test = "${id ==article.id}">
          <input type="button" value ="수정하기"
             onclick="document.location.href='/bbs/update.bbs?articleNum=${article.articleNum}'">
       <input type="button" value ="삭제하기"
             onclick="document.location.href='/bbs/delete.bbs?articleNum=${article.articleNum}'">
   </c:if>
   <c:if test="${id !=article.id } ">
      <input type ="button" value = "수정하기" disabled= "disabled">
      <input type ="button" value = "삭제하기" disabled= "disabled">    
    </c:if>
    <input type ="button" value = "목록으로" onclick="document.location.href='/bbs/list.bbs'">
    </c:if>
    
    <c:if test ="${id ==null}" >
       <input type = "button" value="수정하기" disabled="disabled">
       <input type = "button" value="삭제하기" disabled="disabled">
       <input type = "button" value="목록으로" onclick="document.location.href='/bbs/list.bbs'">
    </c:if>
    
</body>
</html>