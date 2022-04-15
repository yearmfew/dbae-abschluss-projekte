<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />
<div class="studentPageContent">
	<h1>PROFIL DETAILS STUDENT</h1>
	<div class="studentDetailsTable">
		<table class="table table-striped">

			<tbody>
				<tr>
					<th scope="row">Vorname</th>
					<td>${sessionScope.student.getVorname()}</td>
				</tr>
				<tr>
					<th scope="row">Nachname</th>
					<td>${sessionScope.student.getNachname()}</td>
				</tr>
				<tr>
					<th scope="row">Email</th>
					<td>${sessionScope.student.getEmail()}</td>
				</tr>
				<tr>
					<th scope="row">Matrikelnummer</th>
					<td>${sessionScope.student.getMatrikelnummer()}</td>
				</tr>
				<tr>
					<th scope="row">Seminar</th>
					<td>${sessionScope.student.getSeminar()}</td>
				</tr>
				<tr>
					<th scope="row">Studiengang</th>
					<td>${sessionScope.student.getStudiengang()}</td>
				<tr>
					<th scope="row">Abschluss</th>
					<td>${sessionScope.student.getAbschluss()}</td>
				</tr>
				<tr>
					<th scope="row">Seminarthema</th>
					<td>${sessionScope.student.getSeminarthema()}</td>
				</tr>
				<tr>
					<th scope="row">Anzahl der Bewertungen:</th>
					<td>${sessionScope.countOfBewertungen}</td>
				</tr>
				<c:if test="${sessionScope.user.isUserDozent()}">
					<!-- hier muss die bewertung nur für dozent -->
					
					<tr>
					<th scope="row">Note der Ausarbeitung:</th>
					<td>${sessionScope.bewertung.getNote()}</td>
				</tr>
					</c:if>
				
				
			</tbody>
		</table>
		<c:if test="${sessionScope.user.isUserStudent()}">
			<div class="d-flex justify-content-end">
				<a class="btn btn-primary" href="updateProfil.jsp"> Edit <i
					class="fa fa-pencil-square-o" aria-hidden="true"></i>
				</a>
		</c:if>
	</div>
</div>
</div>

<jsp:include page="shared/footer.jsp" />