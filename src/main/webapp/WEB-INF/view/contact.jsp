<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="basic/head-1.1.jsp" />

<title>Contacts</title>

<jsp:include page="basic/head-1.2.jsp" />

<body>
    <noscript>JavaScript is off</noscript>

	<div class="main">
		<jsp:include page="basic/header.jsp" />
			
		<div class="site_content">

			<jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
				<h1>Contacts</h1>

				<p>You can leave a message in the form below</p>
	
				<div class="send send_contact">	
					<form method="post" action="/reviews/add" id="contact">
						<input type="text" name="review_name" placeholder="your name">
						<input type="text" name="review_email" placeholder="your e-mail">
						<textarea name="review_text" style="resize: none"></textarea>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

						<input class="btn" type="submit" value="submit button">
					</form>
				</div>

				<p>You can also contact us by e-mail: <b>freimanvs@gmail.com</b></p>

				<p>Sources of the project are there: <br />
				<a href="https://github.com/FreimanVS/WebProject" target="_blank">github.com/FreimanVS/WebProject</a></p>


			</div>
		</div>

		<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>