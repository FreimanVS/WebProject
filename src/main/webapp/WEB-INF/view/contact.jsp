<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="basic/head-1.1.jsp" />

<title>Контакты</title>

<jsp:include page="basic/head-1.2.jsp" />

<body>
    <noscript>Для правильной работы сайта необходимо включить JavaScript</noscript>

	<div class="main">
		<jsp:include page="basic/header.jsp" />
			
		<div class="site_content">

			<jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
				<h1>Контакты</h1>

				<p>Здесь вы можете оставить ваши отзывы, пожелания и предложения</p>
	
				<div class="send send_contact">	
					<form method="post" action="/reviews/add" id="contact">
						<input type="text" name="review_name" placeholder="ваше имя">
						<input type="text" name="review_email" placeholder="ваш email">
						<textarea name="review_text" style="resize: none"></textarea>
						<input class="btn" type="submit" value="отправить">
					</form>
				</div>

				<br /> или же вы можете связаться с нами по электронной почте: xsplitgames@gmail.com
			</div>
		</div>

		<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>