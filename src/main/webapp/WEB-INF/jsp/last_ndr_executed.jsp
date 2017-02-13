<%@include file="includes/header.jsp"%>

<div class="jumbotron">
	<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading">Here below the last 5 DR's executed!</div>
			    <table class="table table-striped">
			      <thead>
			         <tr>
			          <th>DR Name</th>
			         </tr>
			      </thead>
			      <tbody>
			          <c:forEach var="dr" items="${listOfLastNDRExecuted}">
			            <tr>
			             <td scope="row">${dr}</td>
			            </tr>
			          </c:forEach>
			      </tbody>
			    </table>
		</div>
	</div>
		<form:form class="form-horizontal"  method="post" >
		   <div class="form-group"> 
		     <button type="submit" class="btn btn-primary btn-lg btn-block">Click here to view all environments where the above DR's are installed!</button>
		    </div>
         </form:form>
</div>
<%@include file="includes/footer.jsp"%>