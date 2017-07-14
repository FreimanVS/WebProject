<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="basic/head-1.1.jsp" />

<title>Main page</title>

<jsp:include page="basic/head-1.2.jsp" />

<script type="text/javascript" src="/resources/js/notifications.js"></script>

<body>
	<noscript>JavaScript is off</noscript>

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
					<h2>The portal is created by Freiman V. S.</h2>

					<p>
                        <table border="0">
                            <caption><h2>Technologies on which this project is built:</h2></caption>

                            <thead>
                                <tr>
                                    <th><h3>Backend</h3></th>
                                    <th><h3>Frontend</h3></th>
                                </tr>
                            </thead>

                            <tr>
                                <td>
                                    <ul>
                                        <li>SPRING SECURITY</li>
                                        <li>SPRING MVC</li>
                                        <li>SPRING</li>
                                        <li>HIBERNATE</li>
                                        <li>JSP</li>
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

                    <p>
                        <br >
                        <b>Certificates:</b> <br />
                        Basic:</br />
                        <a href="https://stepik.org/certificate/f0e9969ccc50388d15381248089e16bb8ffbc8b0.pdf" target="_blank">Computer Science Center Certificate</a> <br />
                        Algorithms:</br />
                        <a href="https://stepik.org/certificate/88a384dbefa35b9e2fc701291af29935a332a257.pdf" target="_blank">Computer Science Center Certificate 2</a> <br />
                        <a href="https://stepik.org/certificate/57541308193fb657e08156c671c137abfc3e4b4d.pdf" target="_blank">Computer Science Center Certificate 3</a> <br />
                        Web:</br />
                        <a href="https://stepik.org/certificate/b8041cbeb49524a91750af92d54e7572ff1915bb.pdf" target="_blank">@Mail.ru Group Certificate</a> <br />
                        <a href="https://stepik.org/certificate/d40a6694ae8b83398991c96b29b1c47c241591d8.pdf" target="_blank">@Mail.ru Group Certificate 2</a> <br />
                    </p>
				</div>
			</div>
		</div>

	<jsp:include page="basic/footer.jsp" />
	</div>
</body>
</html>