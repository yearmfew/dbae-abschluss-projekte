<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />
<div class="page-containerMenu">
	<jsp:include page="shared/menu-loggedin.jsp" />
</div>
<div class=" page-containerContent ">
	<div class="seminarPageContent">
		<h1>Seminaren</h1>
		<div class="seminarDetailsTable">
			Table for seminaren ....


			<table class="table table-striped">

				<tbody>
				<thead>
					<tr>
						<th scope="col">Titel</th>
						<th scope="col">Dozent</th>
						<th scope="col">Begriff</th>
						<th scope="col">Beschreibung</th>
						<th scope="col">Semester</th>
						<th></th>
						<th></th>
						
					</tr>
				</thead>
				<c:forEach var="seminar" items="${ sessionScope.seminaren }">
					<tr>
						<td>${seminar.getTitel()}</td>
						<td>${seminar.getDozent().getVorname()}</td>
						<td>${seminar.getTheme()}</td>
						<td>${seminar.getBeschreibung()}</td>		
						<td>${seminar.getSemester()}</td>
						<td>edit <i class="fa fa-pencil-square-o" aria-hidden="true"></i></td>
						
						<td>belegen <i class="fa fa-sign-in" aria-hidden="true"></td>
						
						
				
					</tr>
				</c:forEach>

				</tbody>
			</table>



		</div>
	</div>



	<jsp:include page="shared/footer.jsp" />