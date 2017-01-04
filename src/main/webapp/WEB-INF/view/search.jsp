<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="basic/head-1.1.jsp" />
<jsp:include page="basic/head-1.2.jsp" />

    <body>
        <div class="main">
            <jsp:include page="basic/header.jsp" />

            <div class="site_content">
                <jsp:include page="basic/sidebar_container.jsp" />

                <div class="content">
                    <c:forEach var="tempMovie" items="${movies}">
                        <div class="info_film">
                            <a href="/show?idmovie=${tempMovie.idmovie}"><img src="/resources/images/${tempMovie.logo}"></a>
                                ${tempMovie.description}
                            <div class="button"><a href="/show?idmovie=${tempMovie.idmovie}">Смотреть</a></div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <jsp:include page="basic/footer.jsp" />
        </div>
    </body>
</html>
