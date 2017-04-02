<!--
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

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>

        <jsp:include page="basic/footer.jsp" />
    </div>
</body>
</html>
-->














<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<style>
    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: darkslateblue;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    /* Float cancel and signup buttons and add an equal width */
    signupbtn {
        float: left;
        width: 50%;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
        .cancelbtn, .signupbtn {
            width: 100%;
        }
    }

    .signUpForm {
        width: 50%;
    }

    .error {
        color: #ff0000;
    }
</style>

<div class="error">
    <c:choose>
        <c:when test="${isAlreadyExist != null}">
            <spring:message code="alreadyExists" />
        </c:when>
    </c:choose>
</div>

<div class="error">
    <c:choose>
        <c:when test="${doesntMatch != null}">
            <spring:message code="doesntMatch" />
        </c:when>
    </c:choose>
</div>

<div class="signUpForm">
    <form:form action="/users/add" modelAttribute="user" method="POST">
        <div class="container">
            <span style="float: right">
                <a href="/users/registration?lang=en">en</a>
                <a href="/users/registration?lang=ru">ru</a>
            </span>

            <form:input path="username" placeholder="put your login here" />
            <form:errors path = "username" cssClass="error" />

            <form:password path = "password" placeholder="put your password here" />
            <form:errors path = "password" cssClass="error" />

            <form:password path = "confirmPassword" placeholder="put your password here" />
            <form:errors path = "confirmPassword" cssClass="error" />

            <div class="clearfix">
              <button type="submit" class="signupbtn"><spring:message code="signUp" /></button>
            </div>
        </div>
    </form:form>
</div>

<br /> <a href='/index'><spring:message code="returnToMain" /></a>

















<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="user" action="/users/add">
        <h2>Create your account</h2>

        <div>
            <form:input type="text" path="username" placeholder="Username" autofocus="true" />
            <form:errors path="username" cssClass="error" />
        </div>

        <div>
            <form:input type="password" path="password" placeholder="Password" />
            <form:errors path="password" cssClass="error" />
        </div>

        <div>
            <form:input type="password" path="confirmPassword"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="confirmPassword" cssClass="error" />
        </div>

        <button type="submit">Submit</button>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
-->