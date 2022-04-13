<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />
<div class="page-containerMenu">
	<jsp:include page="shared/menu-loggedin.jsp" />
</div>
<div class=" page-containerContent ">
	<div class="seminarPageContent">
		<h1>Edit Seminar</h1>
		

		<form action="FormEditSeminar" method="POST">
			<div class="mb-2">
				<label for="titel" class="form-label">Titel</label> 
				<input 
				type="text" 
				class="form-control" 
				name="titel" 
				id="titel" 
				placeholder="${sessionScope.seminar.getTitel()}"
				>
				<span class="warning">  ${ titelFehler } </span>
			</div>
			<div class="mb-2">
				<label for="dozent" class="form-label">Dozent</label> 
				
				<select
				class="form-control" id="dozent" name="dozentId" >
					<option value="" disabled selected>
					${sessionScope.seminar.getDozent().getTitel()}
					${sessionScope.seminar.getDozent().getVorname()}
					${sessionScope.seminar.getDozent().getNachname()}
					</option>
					<c:forEach var="dozent" items="${sessionScope.dozenten}">
						<option value="${dozent.getId()}" >
							${dozent.getTitel()} 
							${dozent.getVorname()} 
							${dozent.getNachname()}
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-2">
				<label for="thema" class="form-label">Thema</label> 
				<input 
				type="text" 
				class="form-control" 
				name="thema" 
				id="thema"
				placeholder="${sessionScope.seminar.getThema()}"
				>
				<span class="warning">  ${ themaFehler } </span>
			</div>
			<div class="mb-2">
				<label for="oberbegriff" class="form-label">Oberbegriff</label> 
				<input 
				type="text" 
				class="form-control" 
				name="oberbegriff"
				id="oberbegriff"
				placeholder="${sessionScope.seminar.getOberbegriff()}"
				>
			</div>
			<div class="mb-2">
				<label for="beschreibung" class="form-label">Beschreibung</label> 
				<input 
				type="text" 
				class="form-control" 
				name="beschreibung" 
				id="beschreibung"
				placeholder="${sessionScope.seminar.getBeschreibung()}"
				>
				<span class="warning">  ${ beschreibungFehler } </span>
			</div>
			<div class="mb-2">
				<label for="semester" class="form-label">Semester</label> 
				<input 
				type="text" 
				class="form-control" 
				name="semester"
				id="semester"
				placeholder="${sessionScope.seminar.getSemester()}"
				>
			</div>
				<span class="warning">  ${ semesterFehler } </span>
			<button type="submit" class="btn btn-primary">Speichere Anderungen</button>
		</form>
	</div>



	<jsp:include page="shared/footer.jsp" />