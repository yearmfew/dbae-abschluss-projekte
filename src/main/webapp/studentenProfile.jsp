<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />
<div class="page-containerMenu">
	<jsp:include page="shared/menu-loggedin.jsp" />
</div>
<div class=" page-containerContent ">
	<div class="studentPageContent">
		<h1>Studenten</h1>
		<div class="studentenProfileTable">
			Registrierte Studenten:


			<table class="table table-striped">

				<tbody>
				<thead>
					<tr>
						<th scope="col">Vorname</th>
						<th scope="col">Nachname</th>
						<th></th>
						<th></th>

					</tr>
				</thead>
				<c:forEach var="student" items="${ sessionScope.studenten }">
					<tr>
						<td class="vorname">${student.getVorname()}</td>
						<td class="nachname">${student.getNachname()}</td>
						<td>
						
						<td class="profileDetails">
						<a href="toProfileDetails?method=toProfileDetails&studentId=${student.getId()}">
								Details ansehen <i class="fa fa-info-circle" aria-hidden="true"></i>
						</a>
						</td>


					</tr>
				</c:forEach>

				</tbody>
			</table>



		</div>
	</div>


	<jsp:include page="shared/footer.jsp" />