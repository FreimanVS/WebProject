<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar_container">

    <div class="sidebar" id="chat_div">
        <h2>Чат</h2>
        <div>
            <c:choose>
                <c:when test="${cookie.login.value == null || cookie.login.value == 'nuvottakvot'
                            || cookie.login.value == 'doesntExist'}">
                    <p id="youNeedToLogin">
                        Чтобы писать в чате, необходимо авторизоваться
                    </p>
                </c:when>

                <c:otherwise>
                    <p>
                        Welcome, <input type="button" id="username" value="${cookie.login.value}" readonly="readonly" />
                    </p>
                </c:otherwise>

            </c:choose>

        </div>

        <div>
            <textarea id="messages" rows="10" cols="25" readonly="readonly" style="resize: none"></textarea>
        </div>

        <form name="message" onclick="return false;">
            <input name="usermsg" type="text" id="message" size="40"/>
            <input type="button" name="submitmsg" value="отправить"/>
        </form>
    </div>

    <div class="sidebar">
        <h2>Поиск</h2>
        <form method="post" action="/search" id="search_form" >
            <input type="search" name="search_field" placeholder="ваш запрос" />
            <input type="submit" class="btn" value="найти" />
        </form>
    </div>

    <div class="sidebar">

        <c:choose>
            <c:when test="${cookie.login.value == null || cookie.login.value == 'nuvottakvot'}">
                <h2>Вход</h2>
                <form method="POST" action="/users/authorization" id="login">

                    <input type="text" name="nick" placeholder="логин" />
                    <input type="password" name="password" placeholder="пароль" />
                    <input type="submit" class="btn" value="вход" />
                    <div class="lables_passreg_text">
                        <span><a href="#"><span><a href="/users/registration">регистрация</a></span>
                    </div>

                </form>
            </c:when>

            <c:when test="${cookie.login.value == 'doesntExist'}">
                <h2>Вход</h2>
                Неверный логин или пароль.
                <form method="POST" action="/users/authorization" id="login">

                    <input type="text" name="nick" placeholder="логин" />
                    <input type="password" name="password" placeholder="пароль" />
                    <input type="submit" class="btn" value="вход" />
                    <div class="lables_passreg_text">
                        <span><a href="#">забыли пароль?</a></span> | <span><a href="/users/registration">регистрация</a></span>
                    </div>

                </form>
            </c:when>

            <c:otherwise>
                Привет, ${cookie.login.value}.
                <a href="/users/unlogin">Выход</a>
                <br />
            </c:otherwise>

        </c:choose>

    </div>

    <div class="sidebar">
        <h2>Сообщение дня</h2>
        <span>23.12.2016</span>
        <p>Мы запустили расширенный поиск</p>
        <%--<a href="#">читать</a>--%>
    </div>

    <jsp:include page="/movies/getBestFourSidebar" />
</div>
