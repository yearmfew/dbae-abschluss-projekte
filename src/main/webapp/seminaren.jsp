<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />

<div class="seminarPageContent">
	<h1>Seminaren</h1>
	${sessionScope.seminarNotFound } ${sessionScope.keinSeminarInDB }
	<div class="seminarsTable">
		<table class="table table-striped">
			<tbody>
			<thead>
				<tr>
					<th class="titel" scope="col">Titel</th>
					<th scope="col">Dozent</th>
					<th scope="col">Begriff</th>
					<th scope="col">Status</th>
					<th scope="col">Semester</th>
					<c:if test="${!sessionScope.user.isUserStudent()}">
						<th></th>
					</c:if>
					<c:if test="${!sessionScope.user.isUserStudent()}">
						<th><a href="addSeminar.jsp"> Add Seminar <i
								class="fa fa-plus" aria-hidden="true"></i>
						</a></th>
					</c:if>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="seminar" items="${ sessionScope.seminaren }">
				<tr>
					<td class="titel"><a
						href="toSeminarDetails?method=toSeminarDetails&seminarId=${seminar.getId()}">
							${seminar.getTitel()} </a></td>
					<td>${seminar.getDozent().getTitel()}
						${seminar.getDozent().getVorname()}
						${seminar.getDozent().getNachname()}</td>
					<td>${seminar.getThema()}</td>
					<td>${seminar.isStatus()}</td>
					<td>${seminar.getSemester()}</td>

					<td><c:if test="${!sessionScope.user.isUserStudent()}">
							<a
								href="toAddBewertung?method=toAddBewerung&seminarId=${seminar.getId()}">
								Vortrag Geben <i class="fa fa-commenting-o" aria-hidden="true"></i>
							</a>
						</c:if> <c:if test="${sessionScope.user.isUserStudent()}">
							<a href="belegen?method=belegen&seminarId=${seminar.getId()}">Belegen
								<i class="fa fa-sign-in" aria-hidden="true"></i>
							</a><
						</c:if>
					<td><a
						href="editSeminar?method=editSeminar&seminarId=${seminar.getId()}">
							Edit <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
					</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<jsp:include page="shared/footer.jsp" />