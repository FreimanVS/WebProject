<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="basic/head-1.1.jsp" />

<title>Рейтинг фильмов</title>

<jsp:include page="basic/head-1.2.jsp" />

<body>
    <noscript>Для правильной работы сайта необходимо включить JavaScript</noscript>

	<div class="main">
		<jsp:include page="basic/header.jsp" />

		<div class="site_content">
			<jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
			    <table>
					<tr>
						<th></th>
						<th>Фильм</th>
						<th class="center">Год</th>
						<th class="center">Рейтинг</th>
					</tr>

					<c:forEach var="tempMovie" items="${movies}" varStatus="loop">
                        <tr>
                            <td class="center"><a href="/show?idmovie=${tempMovie.idmovie}"><img src="/resources/images/${tempMovie.logo}"></a></td>
                            <td>${loop.count}. <a href="/show?idmovie=${tempMovie.idmovie}">${tempMovie.namemovie}</a></td>
                            <td class="center">${tempMovie.timefilmed}</td>
                            <td class="center rating">${tempMovie.rating}</td>
                        </tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>