<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="menu">
	<c:if test="${! sessionScope.validLogin}">
		<a class="menu-item" href="login.jsp">Login</a>
		<a class="menu-item" href="registration.jsp">Registrierung</a>
	</c:if>

	<c:if test="${ sessionScope.validLogin }">
		<a class="menu-item" href="index.jsp">Startseite</a>
		<c:if test="${ sessionScope.user.isUserStudent() }">
			<a class="menu-item" href="toProfileDetails?method=toProfileDetails&studentId=${sessionScope.user.getId()}">
				Profil
			</a>
		</c:if>
		<c:if test="${ !sessionScope.user.isUserStudent() }">
			<a class="menu-item" href="initProfil">Registierte Studenten</a>
		</c:if>
		<a class="menu-item" href="initSeminaren">Seminaren</a>


		<!-- will be a form and send to a sevlet for logout -->
		<a class="menu-item" href="logout">Logout</a>
	</c:if>
</div>

