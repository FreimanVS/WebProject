<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax-commentsblock.js"></script>


<style>
    .comments2 {
        display: none;
    }

    #loadMore {
        color:green;
        cursor:pointer;
    }

    #loadMore:hover {
        color:black;
    }

    #showLess {
        color:grey;
        cursor:pointer;
        display:none;
    }

    #showLess:hover {
        color:black;
    }
</style>

<c:forEach var="tempComment" items="${comments}">

    <div class="comments2">
        <div class="reviews">
            <div class="review_name">${tempComment.nick} - ${tempComment.timecomment}</div>
            <div  class="review_text">${tempComment.content}</div>
        </div>
    </div>

</c:forEach>

<div id="loadMore"><p>Load more</p></div>
<div id="showLess"><p>Show less</p></div>