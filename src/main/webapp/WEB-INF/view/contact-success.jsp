<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="basic/head-1.1.jsp" />

<title>Контакты</title>

<jsp:include page="basic/head-1.2.jsp" />

<body>

	<div class="main">

		<jsp:include page="basic/header.jsp" />
			
		<div class="site_content">
			<jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
				Ваше сообщение было успешно отправлено!
				<br />
				<br /> <a href='/contact'>вернуться назад</a>
				<br />
				<br /> <a href='/index'>вернуться на главную страницу</a>
			</div>
		</div>

		<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>