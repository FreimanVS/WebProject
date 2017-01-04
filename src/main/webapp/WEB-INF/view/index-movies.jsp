<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar">
    <h2>Рейтинг фильмов</h2>
    <ul>
        <c:forEach var="tempMovie" items="${movies}">
        <li><a href="show">${tempMovie.namemovie}</a><span class="rating_sidebar">${tempMovie.rating}</span></li>
        </c:forEach>
    </ul>
</div>