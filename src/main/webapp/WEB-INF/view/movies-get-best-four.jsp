<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="films_block">
    <c:forEach var="temp" items="${movies}">
        <a href="/show?idmovie=${temp.idmovie}"><img src="/resources/images/${temp.logo}"></a>
    </c:forEach>
</div>
