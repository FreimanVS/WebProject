<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>admin</title>
</head>
<body>
    <div id="wrapper">
        <header>
            <h1>admin page</h1>
        </header>

        <nav>
            <p>
                <a href="/index">return to the main page</a>
            </p>
        </nav>

        <main>
            <section>
                <h2>work with databases</h2>
                <article>
                    <aside>
                        <a href="${pageContext.request.contextPath}/admin/listComments2">
                           <h3>Comments2 database</h3>
                        </a>
                    </aside>
                </article>
            </section>
        </main>

        <footer>
            <address>freimanvs@gmail.com</address>
            <small>copyright <%= Calendar.getInstance().get(Calendar.YEAR) %></small>
        </footer>
</html>