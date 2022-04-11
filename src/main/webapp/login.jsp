 <jsp:include page = "shared/header.jsp" />
 
  <div class="page-container-menu">
 
 <jsp:include page = "shared/menu-loggedout.jsp" />
 </div>
 <div class=" page-container-content ">
 
<form action="LoginPage" method="POST">
  <div class="mb-3">
    <label for="email"  class="form-label">Email</label>
    <input type="email" required class="form-control" name="email" id="email">
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" required class="form-control" name="password" id="password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
   <span class="warning">
       ${ fehlermeldung }
      </span>
 
  
 <jsp:include page = "shared/footer.jsp" />