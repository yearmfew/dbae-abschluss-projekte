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
						<th scope="col">Status</th>
						<th scope="col">Semester</th>
						<th></th>
						<th></th>
						<th></th>

					</tr>
				</thead>
				<c:forEach var="seminar" items="${ sessionScope.seminaren }">
					<tr>
						<td class="seminarTitle">${seminar.getTitel()}</td>
						<td>${seminar.getDozent().getTitel()}
							${seminar.getDozent().getVorname()}
							${seminar.getDozent().getNachname()}</td>
						<td class="thema">${seminar.getThema()}</td>
						<td>${seminar.isStatus()}</td>
						<td>${seminar.getSemester()}</td>
						<td>
						<!-- 
						 	<button onclick="toEditSeminar(${seminar.getId()})">
								Edit <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
							</button>
						 -->
							<a href="editSeminar?method=editSeminar&seminarId=${seminar.getId()}">
								Edit <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
						</a>
							

						</td>
						<td>Belegen <i class="fa fa-sign-in" aria-hidden="true"></td>
						<td class="seminarDetails">
						<a href="toSeminarDetails?method=toSeminarDetails&seminarId=${seminar.getId()}">
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