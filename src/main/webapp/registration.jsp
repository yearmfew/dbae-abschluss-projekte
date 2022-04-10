<jsp:include page="shared/header.jsp" />
<div class="page-containerMenu">

	<jsp:include page="shared/menu-loggedout.jsp" />
</div>
<div class=" page-containerContent ">

  
<form action="RegistrationPage" method="POST">


  <div class="form-inputs"> 
       <div>
      <label for="vorname" class="form-label">Vorname</label>
      <input type="text" required class="form-control" name="vorname" id="vorname" value= ${ vorname }>
      
    </div>
    <div>
      <label for="nachname" class="form-label">Nachname</label>
      <input type="text" required class="form-control" name="nachname" id="nachname" value= ${ nachname }>
     
    </div>
    <div>
      <label for="matrikelnummer" class="form-label">Matrikelnummer</label>
      <input type="text" required class="form-control" name="matrikelnummer" id="matrikelnummer" value= ${ matrikelnummer }>
     
    </div>
    <div>
      <label for="email" class="form-label">Email</label>
      <input type="email" required class="form-control" name="email" id="email" value= ${ email }>
      <span class="warning">
      ${ emailAlreadyUsed }
      </span>
    </div>
    <div>
      <label for="password"  class="form-label">Passwort</label>
      <input type="password" required class="form-control" name="password" id="password" value= ${ password }>
      
      <span class="warning">
      ${ error }
      </span>
      
   <div>Belegtes Seminar:</div>  
 <div class="form-check">
    <input class="form-check-input" type="checkbox" value="iis" name="iis" id="iis">
    <label class="form-check-label" for="defaultCheck1">
        iis
    </label>
    </div>
    <div class="form-check">
	<input class="form-check-input" type="checkbox" value="wbs" name="wbs" id="wbs">
    <label class="form-check-label" for="defaultCheck2">
        wbs
    </label>
    </div>
 <div>Studiengang:</div>
 
   <div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" id="winf" name="winf" value="winf">
  <label class="form-check-label" for="winf">WINF</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" id="imit" name="imit" value="imit">
  <label class="form-check-label" for="imit">IMIT</label>
</div>
 <div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" id="iim" name="iim" value="iim">
  <label class="form-check-label" for="iim">IIM</label>
</div>
 <div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" id="ikue" name= "ikue" value="ikue">
  <label class="form-check-label" for="ikue">IKÜ</label>
</div>

<div>Abschluss:</div>
 
   <div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" id="bachelor" name="bachelor" value="bachelor">
  <label class="form-check-label" for="inlineCheckbox1">B.Sc</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" id="master" name="master" value="master">
  <label class="form-check-label" for="inlineCheckbox2">M.Sc</label>
</div>
 <div>
      <label for="vorname" class="form-label">Seminarthema</label>
      <input type="text" class="form-control" name="seminarthema" id="seminarthema">
    </div>
  </div>
  <div class="form-buttons"> 
    <button type="submit" class="btn btn-primary">Registrieren</button>
  </div>
</form>



	<jsp:include page="shared/footer.jsp" />