<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>List Comments2</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style2.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Comments2</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">
			<input type="button" value="Add Comments2"
				   onclick="window.location.href='addComments2'; return false;"
				   class="add-button"
			/>

			<form:form action="search" method="POST">
				Search Comments2: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

            <p>
                <a href="${pageContext.request.contextPath}/admin/">Back to Admin Page</a>
            </p>

			<table>
                <tr>
                    <th>id</th>
                    <th>idmovie</th>
                    <th>namemovie</th>
                    <th>timecomment</th>
                    <th>content</th>
                    <th>nick</th>
                    <th>action</th>
                </tr>

                <c:forEach var="temp" items="${comments2}">

                <c:url var="updateLink" value="/admin/updateComments2">
                    <c:param name="id" value="${temp.id}" />
                </c:url>

                <c:url var="deleteLink" value="/admin/deleteComments2">
                    <c:param name="id" value="${temp.id}" />
                </c:url>

                    <tr>
                        <td> ${temp.id} </td>
                        <td> ${temp.idmovie} </td>
                        <td> ${temp.namemovie} </td>
                        <td> ${temp.timecomment} </td>
                        <td> ${temp.content} </td>
                        <td> ${temp.nick} </td>

                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
		</div>
	</div>
</body>
</html>