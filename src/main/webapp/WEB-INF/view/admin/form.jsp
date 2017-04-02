<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style2.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/form-add-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Comments2</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Comments2</h3>

		<form:form action="/admin/saveComments2" modelAttribute="comments2" method="POST">

			<form:hidden path="id" />
			<form:hidden path="timecomment" />

			<table>
				<tbody>

					<tr>
						<td><label>idmovie:</label></td>
						<td><form:input path="idmovie" /></td>
					</tr>

					<tr>
						<td><label>namemovie:</label></td>
						<td><form:input path="namemovie" /></td>
					</tr>

					<tr>
						<td><label>content:</label></td>
						<td><form:input path="content" /></td>
					</tr>

					<tr>
                        <td><label>nick:</label></td>
                        <td><form:input path="nick" /></td>
                    </tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/admin/listComments2">Back to List</a>
		</p>

	</div>

</body>

</html>