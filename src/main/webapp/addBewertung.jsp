<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="shared/header.jsp" />

<div class="addBewertungPageContent">
	<h1>Bewertung Hinzufügen</h1>


	<form action="FormAddBewertung" method="POST">
		<div class="selectBoxDiv">
			<label for="foliengestaltung" class="form-label">Foliengestaltung</label>
			<select class="form-control" id="foliengestaltung"
				name="foliengestaltung">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ fgFehler }</p>
		<div class="selectBoxDiv">
			<label for="spraclichePresentation" class="form-label">Spracliche
				Presentation</label> <select class="form-control"
				id="spraclichePresentation" name="spraclichePresentation">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ spFehler }</p>
		<div class="selectBoxDiv">
			<label for="presentationstil" class="form-label">Presentationstil</label>
			<select class="form-control" id="presentationstil"
				name="presentationstil">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ psFehler }</p>
		<div class="selectBoxDiv">
			<label for="zeitlicheGestaltung" class="form-label">Zeitliche
				Gestaltung</label> <select class="form-control" id="zeitlicheGestaltung"
				name="zeitlicheGestaltung">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ zgFehler }</p>
		<div class="selectBoxDiv">
			<label for="verstandnis" class="form-label">Verstandnis</label> <select
				class="form-control" id="verstandnis" name="verstandnis">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ verstaendnisFehler }</p>
		<div class="selectBoxDiv">
			<label for="inhaltlicheAufbereitung" class="form-label">Inhaltliche
				Aufbereitung</label> <select class="form-control"
				id="inhaltlicheAufbereitung" name="inhaltlicheAufbereitung">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ iaFehler }</p>
		<div class="selectBoxDiv">
			<label for="verknuepfungMitAnderen" class="form-label">Verknüpfung
				mit Anderen</label> <select class="form-control" id="verknuepfungMitAnderen"
				name="verknuepfungMitAnderen">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ vmaFehler }</p>
		<div class="selectBoxDiv">
			<label for="diskassionFuehrung" class="form-label">Diskussions
				Führung</label> <select class="form-control" id="diskassionFuehrung"
				name="diskassionFuehrung">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ dfFehler }</p>
		<div class="selectBoxDiv">
			<label for="beteiligungDiskassionen" class="form-label">Beteiligung
				an Diskussionen <br> (andere Vorträge)
			</label> <select class="form-control" id="beteiligungDiskassionen"
				name="beteiligungDiskassionen">
				<option value="-1">-</option>
				<option value="0">o</option>
				<option value="+1">+</option>
			</select>
		</div>
		<p style="color:red">${ bDFehler }</p>
		<!-- dozent select boxes  cif...-->

		<div>
			<c:if test="${sessionScope.user.isUserDozent()}">
				<h4>Ausarbeitung bewerten</h4>
				<div class="selectBoxDiv">
					<label for="umfang" class="form-label">Umfang</label> <select
						class="form-control" id="umfang" name="umfang">
						<option value="-1">-</option>
						<option value="0">o</option>
						<option value="+1">+</option>
					</select>
				</div>
				<p style="color:red">${ umfangFehler }</p>
				<div class="selectBoxDiv">
					<label for="referenzen" class="form-label">Referenzen</label> <select
						class="form-control" id="referenzen" name="referenzen">
						<option value="-1">-</option>
						<option value="0">o</option>
						<option value="+1">+</option>
					</select>
				</div>
				<p style="color:red">${ referenzenFehler }</p>
				<div class="selectBoxDiv">
					<label for="sprachlicheGestaltung" class="form-label">Sprachliche
						Gestaltung</label> <select class="form-control" id="sprachlicheGestaltung"
						name="sprachlicheGestaltung">
						<option value="-1">-</option>
						<option value="0">o</option>
						<option value="+1">+</option>
					</select>
				</div>
				<p style="color:red">${ sgFehler }</p>
				<div class="selectBoxDiv">
					<label for="inhaltlicheAufbereitung" class="form-label">Inhaltliche
						Aufbereitung</label> <select class="form-control"
						id="inhaltlicheAufbereitung" name="inhaltlicheAufbereitung">
						<option value="-1">-</option>
						<option value="0">o</option>
						<option value="+1">+</option>
					</select>
				</div>
				<p style="color:red">${ iaFehler }</p>
				<div class="selectBoxDiv">
					<label for="schwierigkeitsgrad" class="form-label">Schwierigkeitsgrad</label>
					<select class="form-control" id="schwierigkeitsgrad"
						name="schwierigkeitsgrad">
						<option value="-1">-</option>
						<option value="0">o</option>
						<option value="+1">+</option>
					</select>
				</div>
				<p style="color:red">${ skgFehler }</p>
			</c:if>
		</div>




		<div class="freitext form-group">
			<label for="kommentar">Freitextkommentar</label>
			<textarea class="form-control"
				placeholder="Geben sie ihre extra kommentar hier ein" id="kommentar"
				name="kommentar"></textarea>
			<span class="warning">${kommentarFehler}</span>
		</div>
		<!-- 
		TODO: hinzufüge die andere bereichen..
		zeige nicht diese bereichen für students nur für dozent
		nutze das gleiche servlet und funktionen. 
		brauchst du keine neue funktion oder database connection schreiben!!
		-->

		<button type="submit" class="btn btn-primary mt-2">Bewertung
			speichern</button>
	</form>
</div>



<jsp:include page="shared/footer.jsp" />