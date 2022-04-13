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
${ sessionScope.validLogin }
--
${ sessionScope.student.getVorname() } --
${ sessionScope.user.getUserType() }

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
						<th><a href="addSeminar.jsp">
								Add Seminar <i class="fa fa-plus" aria-hidden="true"></i>
							</a></th>

					</tr>
				</thead>
				<c:forEach var="seminar" items="${ sessionScope.seminaren }">
					<tr>
						<td class="seminarDetails seminarTitel">
						<a href="toSeminarDetails?method=toSeminarDetails&seminarId=${seminar.getId()}">
								${seminar.getTitel()}
						</a>
						</td>
						<td>${seminar.getDozent().getTitel()}
							${seminar.getDozent().getVorname()}
							${seminar.getDozent().getNachname()}</td>
						<td class="thema">${seminar.getThema()}</td>
						<td>${seminar.isStatus()}</td>
						<td>${seminar.getSemester()}</td>
						<td>
							<c:if test="${!sessionScope.user.isUserStudent()}">
                            <td><a
                                href="editSeminar?method=editSeminar&seminarId=${seminar.getId()}">
                                    Edit <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            </a></td>
                        </c:if>
					</tr>
				</c:forEach>

				</tbody>
			</table>



		</div>
	</div>


	<jsp:include page="shared/footer.jsp" />