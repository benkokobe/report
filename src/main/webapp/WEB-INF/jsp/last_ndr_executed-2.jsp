<%@include file="includes/header.jsp"%>

<div class="jumbotron">
	<div class="panel-group">
		<div class="panel panel-primary">
			<c:forEach var="release_dr"
				items="${lastNDRExecuted.listOfNDRexecuted}">
				<div class="panel-heading">${release_dr.drName}</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Company</th>
							<th>Environment</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="destination"
							items="${release_dr.listOfDestinations}">
							<c:if test="${fn:containsIgnoreCase(destination, 'BLD')}">
								<tr>
									<td>Build Environment</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'BAP')}">
								<tr>
									<td>Build Environment</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'TST')}">
								<tr>
									<td>AC5</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'ACP')}">
								<tr>
									<td>SI2</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'MIG')}">
								<tr>
									<td>MIG</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'ACC')}">
								<tr>
									<td>ACC</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'SIM')}">
								<tr>
									<td>SIM</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'PRD')}">
								<tr>
									<td>PRD</td>
									<td scope="row">${destination}</td>
								</tr>
							</c:if>
							<c:if test="${fn:containsIgnoreCase(destination, 'DVL')}">
								<tr>
									<td>DVL</td>
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