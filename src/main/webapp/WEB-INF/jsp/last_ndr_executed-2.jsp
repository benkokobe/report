<%@include file="includes/header.jsp"%>

<div class="jumbotron">
<div class="panel-group">
	<div class="panel panel-primary">
		<c:forEach var="release_dr" items="${lastNDRExecuted.listOfNDRexecuted}">
			<div class="panel-heading">${release_dr.drName}</div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Company</th>
									<th>Environment</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="destination" items="${release_dr.listOfDestinations}">
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
							<c:if test="${fn:containsIgnoreCase(destination, 'VTB')}">
								<tr>
									<td>VTB</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							</c:forEach>
							</tbody>
							</table>
				

		</c:forEach>
	</div>
	</div>

</div>

<%@include file="includes/footer.jsp"%>