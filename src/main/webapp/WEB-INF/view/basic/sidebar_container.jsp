<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar_container">
    <div class="sidebar">
        <c:choose>
            <c:when test="${pageContext.request.remoteUser == null}">
                <h2>Login</h2>

                <c:if test="${param.error != null}">
                    <p style="color:red">Invalid username or password.</p>
                </c:if>

                <c:if test="${param.logout != null}">
                    <p style="color:green">You have been logged out.</p>
                </c:if>

                <form method="post" action="/login" id="login">
                    <input type="text" name="username" placeholder="your name" />
                    <input type="password" name="password" placeholder="your password" />

                    <label for="remember-me">remember: </label>
                    <input type="checkbox" name="remember-me" />

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <input type="submit" class="btn" value="accept" />
                    <div class="lables_passreg_text">
                        <a href="/users/registration">dont have an account?</a></span>
                    </div>
                </form>
            </c:when>

            <c:otherwise>
                <h2>Welcome,</h2> <b><c:out value="${pageContext.request.remoteUser}"/></b>

                <c:url var="logoutUrl" value="/logout"/>
                <form action="${logoutUrl}" method="post" id="login">
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  <input type="submit" value="Log out" />
                </form>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="sidebar" id="chat_div">
        <h2>Chat</h2>

        <div>
            <c:choose>
                <c:when test="${pageContext.request.remoteUser == null}">
                    <div>
                        <textarea id="messages" rows="10" cols="25" readonly="readonly" style="resize: none"></textarea>
                    </div>

                    <p id="youNeedToLogin">
                        To chat you need to be logged in.
                    </p>
                </c:when>

                <c:otherwise>
                    <input type="hidden" id="username" value="${pageContext.request.remoteUser}" />

                    <div>
                        <textarea id="messages" rows="10" cols="25" readonly="readonly" style="resize: none"></textarea>
                    </div>

                    <form name="message" onclick="return false;">
                        <input name="usermsg" type="text" id="message" size="40"/>
                        <input type="button" name="submitmsg" value="send"/>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="sidebar">
        <h2>Search</h2>
        <form method="get" action="/search" id="search_form" >
            <input type="search" name="search_field" placeholder="your request" />
            <input type="submit" class="btn" value="find" />
        </form>
    </div>

    <div class="sidebar">
        <h2>A message of a day</h2>
        <span>23.12.2016</span>
        <p>We have launched an advanced search bar</p>
        <%--<a href="#">read more</a>--%>
    </div>

    <jsp:include page="/movies/getBestFourSidebar" />
</div>
