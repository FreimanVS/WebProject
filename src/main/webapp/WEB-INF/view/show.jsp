<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="basic/head-1.1.jsp" />

<title>${movie.namemovie}</title>

<jsp:include page="basic/head-1.2.jsp" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/comments.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajax.js"></script>

<body>
    <noscript>Для правильной работы сайта необходимо включить JavaScript</noscript>

	<div class="main">
		<jsp:include page="basic/header.jsp" />

		<div class="site_content">
			<jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
				<h1>${movie.namemovie}</h1>
				
				<iframe width="560" height="315" src="${movie.video}" frameborder="0" allowfullscreen></iframe>

				<div class="info_film_page">
					<span class="label">рейтинг: </span><span class="value" id="ratingToFixed">${movie.rating} / 5</span>
					<span class="label">год: </span><span class="value">${movie.timefilmed}</span>
					<span class="label">режиссер: </span><span class="value">${movie.director}</span>
					<br />
					<br />оцените фильм:

					<c:choose>
						<c:when test="${cookie.login.value == null || cookie.login.value == 'nuvottakvot' || cookie.login.value == 'doesntExist'}">
							<p style="color: red">Чтобы проголосовать, вам необходимо авторизоваться.</p>
						</c:when>

						<c:otherwise>
							<form action="/grades/update" method="GET">
							    <input type="radio" name="grade" value="0" style="display:none" checked>
								<input type="radio" name="grade" value="1">
								<input type="radio" name="grade" value="2">
								<input type="radio" name="grade" value="3">
								<input type="radio" name="grade" value="4">
								<input type="radio" name="grade" value="5">
								<input type="hidden" name="idmovie" value="${movie.idmovie}">
								<input type="hidden" name="nick" value="${cookie.login.value}" />

								<input type="submit" value="Оценить">
							</form>
						</c:otherwise>
					</c:choose>
				</div>

				<hr>

				<h2>Описание ${movie.namemovie}</h2>

				<div class="descriptions_film">
					<img src="${pageContext.request.contextPath}/resources/images/${movie.logo}">
					${movie.description}
				</div>

				<hr>

				<h2>Отзывы о ${movie.namemovie}</h2>

                <div id="information"></div>

                <c:choose>
                    <c:when test="${cookie.login.value == null || cookie.login.value == 'nuvottakvot' || cookie.login.value == 'doesntExist'}">
                        <p style="color: red">Чтобы отправить отзыв, вам необходимо авторизоваться.</p>
                    </c:when>

                    <c:otherwise>
                        <div class="send" style="display:none" id="sendcommentdiv">
                            <input type="hidden" name="nick" value="${cookie.login.value}" />
							<input type="hidden" name="idmovie" value="${movie.idmovie}" />
							<input type="hidden" name="namemovie" value="${movie.namemovie}" />
                            <textarea id="textarea" name="content" style="resize: none"></textarea>

                            <input type="submit" id="testid" value="Add comment" name="send" class="btn" />
                        </div>

                        <a href="#" onclick="return false" id="add_comment">Add comment</a>
                    </c:otherwise>
                </c:choose>
			</div>
		</div>

		<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>