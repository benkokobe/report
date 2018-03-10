<%@include file="includes/header.jsp"%>

<div class="jumbotron">
<div class="panel-group">
<div class="panel panel-primary">
  <div class = "panel-heading">
       Here below the SQL needed to get the records related to the DB member
  </div>
<div class="panel panel-info">
  <div class = "panel-heading">
  
<table class="table">
  <!-- <thead class="thead-inverse"> -->
    <tr>
      <th>
      <pre>
      Member name : ${member_description.name}
      Group Name  : ${member_description.group}
      Member type : ${member_description.type}
      </pre>
      </th>
    </tr>
  <!--  </thead> -->
</table>
</div>

</div>
<div class = "panel-body">
<!--  <table> -->	
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
<!-- </table>-->
</div>
<br>
</div>
</div>
</div>
<%@include file="includes/footer.jsp"%>