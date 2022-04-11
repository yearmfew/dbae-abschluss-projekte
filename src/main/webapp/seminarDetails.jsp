
<jsp:include page="shared/header.jsp" />
<div class="page-containerMenu">
	<jsp:include page="shared/menu-loggedin.jsp" />
</div>
<div class=" page-containerContent ">
	<div class="seminarPageContent">
		<h1>Seminar Details</h1>
		<div class="seminarDetailsTable">
			<table class="table table-striped">

				<tbody>
					<tr>
						<th scope="row">Titel</th>
						<td>${sessionScope.seminar.getTitel()}</td>
					</tr>
					<tr>
						<th scope="row">Dozent</th>
						<td>${sessionScope.seminar.getDozent().getVorname()} ${sessionScope.seminar.getDozent().getNachname()}</td>
					</tr>
						<tr>
						<th scope="row">Thema</th>
						<td>${sessionScope.seminar.getTheme()}</td>
					</tr>
					<tr>
						<th scope="row">Oberbegriff</th>
						<td>${sessionScope.seminar.getOberbegriff()}</td>
					</tr>
					<tr>
						<th scope="row">Beschreibung</th>
						<td>${sessionScope.seminar.getBeschreibung()}</td>
					</tr>
					<tr>
						<th scope="row">Zugewiesener Student</th>
						<td>${sessionScope.seminar.getZugewissenerStudent().getVorname()} ${sessionScope.seminar.getZugewissenerStudent().getNachname()}</td>
					</tr>
					<tr>
						<th scope="row">Semester</th>
						<td>${sessionScope.seminar.getSemester()}</td>
					</tr>
					<tr>
						<th scope="row">Status</th>
						<td>${sessionScope.seminar.isStatus()}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>



	<jsp:include page="shared/footer.jsp" />