<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar">
    <h2>Рейтинг фильмов</h2>

    <ul>
        <c:forEach var="temp" items="${movies}">
            <li><a href="/show?idmovie=${temp.idmovie}">${temp.namemovie}</a><span class="rating_sidebar">${temp.rating}</span></li>
        </c:forEach>
    </ul>
</div>