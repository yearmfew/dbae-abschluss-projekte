<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />
<div class="page-containerMenu">
	<jsp:include page="shared/menu-loggedin.jsp" />
</div>
<div class=" page-containerContent ">
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
						<c:if test="${!sessionScope.user.isUserStudent()}">
                            <td><a
                                href="ProfilePage?method=ProfilePage&studentId=${student.getId()}">
                                    Edit <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            </a></td>
                        </c:if>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


