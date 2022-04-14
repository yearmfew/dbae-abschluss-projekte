<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />
<div class=" page-containerContent ">
	<div class="addSeminarPageContainer">
		<h1>Add Seminar</h1>
		<form action="FormAddSeminar" method="POST">
			<div class="mb-2">
				<label for="titel" class="form-label">Titel</label> 
				<input 
				type="text" 
				class="form-control" 
				name="titel" 
				id="titel" 
				placeholder="Geben Sie Seminar Titel ein"
				>
				<span class="warning"> fehler message here.. </span>
			</div>
		

			<div class="mb-2">
				<label for="thema" class="form-label">Thema</label> 
				<input 
				type="text" 
				class="form-control" 
				name="thema" 
				id="thema"
				placeholder="Geben Sie Seminarthema ein"
				>
				<span class="warning"> fehler message here.. </span>
			</div>
			<div class="mb-2">
				<label for="oberbegriff" class="form-label">Oberbegriff</label> 
				<input 
				type="text" 
				class="form-control" 
				name="oberbegriff"
				id="oberbegriff"
				placeholder="Geben Sie Seminaroberbegriff ein"
				>
				<span class="warning"> fehler message here.. </span>
			</div>
			<div class="mb-2">
				<label for="beschreibung" class="form-label">Beschreibung</label> 
				<input 
				type="text" 
				class="form-control" 
				name="beschreibung" 
				id="beschreibung"
				placeholder="Geben Sie Seminar Beschreibung ein"
				>
				<span class="warning"> fehler message here.. </span>
			</div>
			<div class="mb-2">
				<label for="semester" class="form-label">Semester</label> 	
				<select
				class="form-control" id="semester" name="semester" >
					<option value="" disabled selected>
					Wahlen Sie Semester
					</option>
					
						<option value="Sose2022" >
							Sose2022
						</option>
						<option value="Wise2023" >
							Wise2023
						</option>
						<option value="Sose2023" >
							Sose2023
						</option>
					
				</select>
				<span class="warning"> fehler message here.. </span>
			</div>
			<button type="submit" class="btn btn-primary">Add Seminar</button>
		</form>
	</div>


	<jsp:include page="shared/footer.jsp" />