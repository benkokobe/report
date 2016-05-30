<%@include file="includes/header.jsp"%>

<div class="jumbotron">

<table class="table">
  <thead class="thead-inverse">
    <tr>
      <th>Release name :</th>
      <th>Release synopsis:</th>
      <th>Linked DR:</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${releaseManager.releaseName}</td>
      <td>${releaseManager.synopsisOfRelease}</td>
      <td>${releaseManager.numberOfLinkedDr}</td>
    </tr>
  </tbody>
</table>
<tr>
	<td><c:choose>
 <c:when test="${releaseManager.numberOfLinkedDr eq 0}">
 <table class="table table-reflow">
		  <thead>
		    <tr>
		      <th>Nr. of patches</th>
		      <th>Nr. of transfer operation</th>
		      <th>Nr. of manual operations</th>
		      <th>Nr. of subjects</th>
		    </tr>
		  </thead>
		  <tbody>
				<tr>
			    	<td>${releaseManager.singleDeploymentRequest.numberOfPatches}</td>
					<td>${releaseManager.singleDeploymentRequest.numberOfTransferOperations}</td>
					<td>${releaseManager.singleDeploymentRequest.numberOfManualTransferOperations}</td>
					<td>${releaseManager.singleDeploymentRequest.numberOfSubjects}</td>
				</tr>
		 </tbody>
  </table>
		</c:when>
		<c:otherwise>
			<table class="table table-reflow">
				<thead>
					    <tr>
					      <th>Name of DR</th>
					      <th>Nr. of patches</th>
					      <th>Nr. of transfer operation</th>
					      <th>Nr. of manual operations</th>
					      <th>Nr. of subjects</th>
					    </tr>
			      </thead>
				<c:forEach items="${releaseManager.linkedDeploymentRequest}" var="deploymentRequest">
			        <tbody>
					    <tr>
						  <td>${deploymentRequest.drName}</td>
					      <td>${deploymentRequest.numberOfPatches}</td>
					      <td>${deploymentRequest.numberOfTransferOperations}</td>
					      <td>${deploymentRequest.numberOfManualTransferOperations}</td>
					      <td>${deploymentRequest.numberOfSubjects}</td>
					    </tr>
                   </tbody>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose></td>
</tr>
<div class="row">
	<div class="col-md-8">
			<a class="btn btn-default" href="${releaseManager.releaseName}.xls?releaseName=${releaseManager.releaseName}" role="button">Generate Excel</a>
	</div>
</div>
</div>
<%@include file="includes/footer.jsp"%>
