<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="basic/head-1.1.jsp" />

<title>регистрация нового пользователя</title>

<jsp:include page="basic/head-1.2.jsp" />

<body>
    <noscript>Для правильной работы сайта необходимо включить JavaScript</noscript>

    <div class="main">
        <jsp:include page="basic/header.jsp" />

        <div class="site_content">
            <jsp:include page="basic/sidebar_container.jsp" />

            <div class="content">
                <form action="/users/add" method="POST">
                    <input type="text" name="nick" placeholder="nick" />
                    <input type="password" name="password" placeholder="password" />

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>

        <jsp:include page="basic/footer.jsp" />
    </div>
</body>
</html>
