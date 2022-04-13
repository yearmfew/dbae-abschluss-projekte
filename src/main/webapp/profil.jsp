
<jsp:include page="shared/header.jsp" />

<div class="page-container-menu">

	<jsp:include page="shared/menu.jsp" />
</div>
<div class=" page-container-content ">

	<form action="ProfilePage" method="GET">


		<div class="container bootstrap snippets bootdey"></div>
		<!-- editierbarer form nur für studenten.-->

		<h3>Profil bearbeiten:</h3>

		<form class="form-horizontal" role="form">
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Vorname</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="vorname" placeholder="${ sessionScope.student.getVorname() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Nachname</label>
				<div class="col-lg-8">
					<input class="form-control" type="text"  name="nachname" placeholder="${ sessionScope.student.getNachname() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Matrikelnummer</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="matrikelnummer"
						placeholder="${ sessionScope.student.getMatrikelnummer() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Email</label>
				<div class="col-lg-8">
					<input class="form-control" type="email" name="email" placeholder="${ sessionScope.student.getEmail() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Studiengang</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="studiengang" placeholder="${ sessionScope.student.getStudiengang() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Seminar</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="seminar" placeholder="${ sessionScope.student.getSeminar() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Abschluss</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="abschluss" placeholder="${ sessionScope.student.getAbschluss() } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Seminarthema:</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="seminarthema" placeholder="${ sessionScope.student.getSeminarthema() } ">
				</div>
				
			</div>
			
	<div class="form-inputs">
			<div>
			<h5>Geben Sie ihr Passwort ein um die Änderungen zu bestätigen.</h5>
				<label for="passwort" class="form-label">Passwort:</label> <input type="text"
					 required class="form-control" name="passwort" id=""
					value=${ passwort }>

			</div>
		</div>
		<div class="form-buttons">
				<button type="submit" class="btn btn-primary">Speichern</button>
			</div>
	</form>
		</form>
	</form>



	<!--  sendet eingebene passwort zur session -->
	
	<form action="ProfilePage" method="POST">

	
	<jsp:include page="shared/footer.jsp" />