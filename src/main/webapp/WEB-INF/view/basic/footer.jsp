<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="footer">
    <p>
        <a href="index">Главная</a> |
        <a href="films">Фильмы</a> |
        <a href="rating">Рейтинг фильмов</a> |
        <a href="contact">Контакты</a>
    </p>
    <p>
        Всё О Кино &copy; <%= Calendar.getInstance().get(Calendar.YEAR) %>
    </p>
</div>
