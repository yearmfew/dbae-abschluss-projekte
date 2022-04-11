
<jsp:include page="shared/header.jsp" />

<div class="page-container-menu">

	<jsp:include page="shared/menu-loggedout.jsp" />
</div>
<div class=" page-container-content ">

	<form action="ProfilePage" method="GET">


		<div class="container bootstrap snippets bootdey"></div>
		<!-- editierbarer form nur für studenten.-->

		<h3>Profil bearbeiten:</h3>

		<form class="form-horizontal" role="form">


			<div class="form-group">
				<label class="col-lg-3 control-label">Vorname:</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="vorname" placeholder="${ vorname } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Nachname</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="${ nachname } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Matrikelnummer</label>
				<div class="col-lg-8">
					<input class="form-control" type="text"
						value="${ matrikelnummer } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Email</label>
				<div class="col-lg-8">
					<input class="form-control" type="email" value="${ email } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Studiengang</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="${ studiengang } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Seminar</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="${ seminar } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Abschluss</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="${ abschluss } ">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Seminarthema:</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="${ seminarthema }">
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