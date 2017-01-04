<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach var="tempMovie" items="${movies}">
    <div class="info_film">
        <a href="/show?idmovie=${tempMovie.idmovie}"><img src="${pageContext.request.contextPath}/resources/images/${tempMovie.logo}"></a>

        ${tempMovie.description}

        <div class="button"><a href="/show?idmovie=${tempMovie.idmovie}">Смотреть</a></div>
    </div>
</c:forEach>
