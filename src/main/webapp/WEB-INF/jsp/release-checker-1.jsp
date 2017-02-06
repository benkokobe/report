<%@include file="includes/header.jsp"%>	

<div class="jumbotron">
<div class="panel-group">
<div class="panel panel-primary">  
    <div class = "panel-heading">
        Last DR executed is: <strong><blink>${lastDrExecuted}</blink></strong>. It's installed in the following environments.
    </div>
  
 <div class="table-responsive">
  <table class="table table-bordered" style="width:100%">
  <thead>
    <tr>
      <th>Company</th>
      <th>Environment</th>
    </tr>
  </thead>
 <tbody>
<c:forEach var="destination" items="${releaseCheckManager.releaseDR.listOfDestinations}">

   <c:if test="${fn:containsIgnoreCase(destination, 'BLD')}">
      <tr>
         <td>Build Environment</td>
         <td scope="row">${destination}</td>
    </tr>
   </c:if>
   <c:if test="${fn:containsIgnoreCase(destination, 'EVI')}">
      <tr>
         <td>EVI</td>
         <td scope="row">${destination}</td>
    </tr>
   </c:if>
   <c:if test="${fn:containsIgnoreCase(destination, 'NIB')}">
      <tr>
         <td>NIBC</td>
         <td scope="row">${destination}</td>
    </tr>
   </c:if>
   <c:if test="${fn:containsIgnoreCase(destination, 'SANT')}">
      <tr>
         <td>SANTANDER</td>
         <td scope="row">${destination}</td>
    </tr>
   </c:if>
   <c:if test="${fn:containsIgnoreCase(destination, 'EWU')}">
      <tr>
         <td>EWUB</td>
         <td scope="row">${destination}</td>
    </tr>
   </c:if>
</c:forEach>
</tbody>
</table>
</div>
</div>
  
  <div class="panel panel-info">
  <div class = "panel-heading">
      You can also check another DR for status of installation.
  </div>
  <div class = "panel-body">
      <form:form class="form-horizontal"  method="post" modelAttribute="releaseCheckManager">
         <div class="form-group">
            <label class="control-label col-sm-2" for="releaseName">DR Name:</label>
            <div class="col-sm-4">          
              <!-- <input type="password" class="form-control" id="p	wd" placeholder="Enter password">-->
              <form:input path="releaseName" class="form-control" placeholder="Enter DR name here"/>
            </div>
         </div>
     <div class="form-group">        
       <div class="col-sm-offset-2 col-sm-1">
        <button type="submit" class="btn btn-default">Submit</button>
       </div>
    </div>
  <!-- </form> -->
  </form:form>
</div>
</div>
</div>
</div>
<%@include file="includes/footer.jsp"%>