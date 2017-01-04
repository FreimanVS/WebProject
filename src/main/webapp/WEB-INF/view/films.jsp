<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="basic/head-1.1.jsp" />

<title>Фильмы</title>

<jsp:include page="basic/head-1.2.jsp" />

	<div class="main">

		<jsp:include page="basic/header.jsp" />

		<div class="site_content">
            <jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
				<jsp:include page="/movies/get" />
			</div>
		</div>

		<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>