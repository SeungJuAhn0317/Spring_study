<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script type = "text/javascript">
$(document).ready(function(){
    $("#commentWrite").on("click", function() {
       $.ajax({
          type : "POST",
          async : true,
          dataType : "json",
          url:"/bbs/commentWrite.comment",
          data:{
             commentContent:$("#commentContent").val(), 
             articleNum:"${article.articleNum}"
             },
          beforeSend : function() {
             alert("시작 전");
          },
          complete : function() {
             alert("완료 후");
          },
          error : function(xhr) {
             alert("error html = " + xhr.statusText);
          },
          success:function(data){
               let html = "<table border='1' width= '500' align = 'center'>";
               $.each(data, function(index,item){
                  html +="<tr>";
                  html +="<td>" +(index+1)+"</td>";
                  html +="<td>"+item.id+"</td>";
                  html +="<td>"+ item.commentContent+"</td>";
                  html +="<td>"+ item.commentDate+"</td>";
                  html +="</tr>"
               });
               html +="</table>";
               
               $("#showComment").html(html);
               $("#commentContent").val("");
               $("#commentContent").focus();
               }   
       });
    });
 });
</script>
</head>
<body>
   글번호 : ${article.articleNum}<br>
    아이디 : ${article.id}<br>
    제목 : ${article.title}<br>
    내용 : ${article.content}<br>
    날짜 : ${article.writeDate}<br><br>
    <hr/>
    
    <div>
    <ul>
    <c:forEach var ="file" items = "${fileList}">
   <li> <a href="/bbs/download.bbs?savedFileName=${file.savedFileName}">${file.originalFileName}</a></li>   
    </c:forEach>
    </ul>
 
    </div>
    
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
    <br><br>
    
    
    <div>
    
      <textarea rows = "5" cols="70" id="commentContent"></textarea><br>
      
      <c:if test = "${id ==null }">
         <input type = "button" value ="comment 쓰기" disabled = "disabled">
         </c:if> 
         <c:if test = "${id !=null }">
         <input type = "button" value ="comment 쓰기" id = "commentWrite">
         </c:if>   
      <input type="button" value = "comment 읽기()" onclick="getComment(1,event)" id="commentRead">

    </div><br>
    
    <div id="showComment" > 
    
    
    </div>
    
</body>
</html>