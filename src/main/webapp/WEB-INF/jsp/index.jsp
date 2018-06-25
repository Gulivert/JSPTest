<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript">
	function redirectPage(pageName) {
		window.location.href = pageName;
	}
</script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">LottoLand</a>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<div class="header">

				<div class="buttons">
					<div class="button">
						<form action="${pageContext.request.contextPath}/create"
							method="POST">
							<input type="submit" class="btn" value="Create" />
						</form>
					</div>
					<div class="button">
						<form action="${pageContext.request.contextPath}/restart"
							method="POST">
							<input type="submit" class="btn" value="Restart" />
						</form>
					</div>
				</div>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Player 1</th>
						<th scope="col">Player 2</th>
						<th scope="col">Winner</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="game" items="${games}">
						<tr>
							<td><c:out value="${game.movePlayer1}" /></td>
							<td><c:out value="${game.movePlayer2}" /></td>
							<td><c:choose>
									<c:when test="${game.winner == 0}">Draw</c:when>
									<c:when test="${game.winner == 1}">Player 1</c:when>
									<c:when test="${game.winner == 2}">Player 2</c:when>
									<c:otherwise>undefined</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
