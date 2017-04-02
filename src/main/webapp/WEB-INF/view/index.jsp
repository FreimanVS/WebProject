<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="basic/head-1.1.jsp" />

<title>Главная страница</title>

<jsp:include page="basic/head-1.2.jsp" />

<script type="text/javascript" src="/resources/js/notifications.js"></script>

<body>
	<noscript>Для правильной работы сайта необходимо включить JavaScript</noscript>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/admin/">to ADMIN PAGE</a>
    </sec:authorize>

	<div class="main">
		<jsp:include page="basic/header.jsp" />
			
		<div class="site_content">
			<jsp:include page="basic/sidebar_container.jsp" />

			<div class="content">
				<h1>Новые фильмы</h1>

				<jsp:include page="/movies/getBestFour" />

				<div id="technologies">
					<h2>Этот ресурс создан Фрейман В.С.</h2>

					<p>
                        <table border="0">
                            <caption><h2>Технологии, на которых построен данный проект:</h2></caption>

                            <thead>
                                <tr>
                                    <th><h3>Backend</h3></th>
                                    <th><h3>Frontend</h3></th>
                                </tr>
                            </thead>

                            <tr>
                                <td>
                                    <ul>
                                        <li>J2EE</li>
                                        <li>SPRING SECURITY</li>
                                        <li>SPRING MVC</li>
                                        <li>SPRING</li>
                                        <li>HIBERNATE</li>
                                        <li>JDBC</li>
                                        <li>JSP & SERVLETS</li>
                                        <li>JSTL</li>
                                        <li>MYSQL</li>
                                        <li>TOMCAT</li>
                                        <li>WEBSOCKET</li>
                                        <li>MAVEN</li>
                                        <li>VALIDATION</li>
                                        <li>l10n i18n</li>
                                    </ul>
                                </td>
                                <td>
                                    <ul>
                                        <li>HTML</li>
                                        <li>CSS</li>
                                        <li>JAVA SCRIPT</li>
                                        <li>JQUERY</li>
                                        <li>AJAX</li>
                                    </ul>
                                </td>
                            </tr>
                        </table>
                    </p>

                    <b>OTHER TOOLS</b>: GIT, IntelliJ IDEA, Eclipse, *nix OS, bash.
				</div>
			</div>
		</div>

	<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>