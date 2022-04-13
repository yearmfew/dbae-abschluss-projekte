<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="menu">
<c:if test="${! sessionScope.validLogin}">
    <a class="menu-item" href="login.jsp">Login</a>
    <a class="menu-item" href="registration.jsp">Registrierung</a>
</c:if>

<c:if test="${ sessionScope.validLogin }">
	<a class="menu-item" href="startseite.jsp">Startseite</a> 
	<a class="menu-item" href="profil.jsp">Profil</a> 
	<a class="menu-item" href="verwaltung.jsp">Vervaltung</a>
	<a class="menu-item" href="initSeminaren">Seminaren</a>
	<a class="menu-item" href="initProfil">Profil</a>
	
	<!-- will be a form and send to a sevlet for logout -->
	<a class="menu-item" href="#">Logout</a>
</c:if>
</div>