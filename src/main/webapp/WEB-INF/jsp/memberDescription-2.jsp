<%@include file="includes/header.jsp"%>

<div class="jumbotron">

<table class="table">
  <thead class="thead-inverse">
    <tr>
      <th>
      <pre>
      Member name : ${member_description.name}
      Group Name  : ${member_description.group}
      Member type : ${member_description.type}</pre>
      </th>
    </tr>
  </thead>
</table>
<table>	
<table class="table table-reflow"> 
				<c:forEach items="${member_description.mySqlQueries}" var="sqlQuery">
			        <tbody>
					    <tr>
						  <th>${sqlQuery.table}</th>
					      <td>${sqlQuery.query}</td>
					      
					    </tr>
                   </tbody>
				</c:forEach>
</table>
</table>
<br>
</div>
<%@include file="includes/footer.jsp"%>