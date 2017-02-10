<%@include file="includes/header.jsp"%>

    <!--  Google Chart -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    if ('${releaseManager.numberOfLinkedDr}' == 0){
    	google.charts.load('current', {'packages':['bar']});
    }else{
    	google.charts.load('current', {'packages':['corechart']});
    }
      
      google.charts.setOnLoadCallback(drawVisualization);


      function drawVisualization() {
        
    	if ('${releaseManager.numberOfLinkedDr}' == 0){
    		var data = google.visualization.arrayToDataTable([
    		                   ['Deployment Request', '# of patches', '# of TFT operations', '# of manual op.'],
    		                   ['${releaseManager.releaseName}', '${releaseManager.singleDeploymentRequest.numberOfPatches}', 
    		                   '${releaseManager.singleDeploymentRequest.numberOfTransferOperations}',
    		                   '${releaseManager.singleDeploymentRequest.numberOfManualTransferOperations}']
    		                   ]);
    		var options = {
    		          chart: {
    		            title: '${releaseManager.releaseName}',
    		            subtitle: '${releaseManager.synopsisOfRelease}',
    		          }
    		        };
    		var chart = new google.charts.Bar(document.getElementById('chart_div'));
        }else{
        			
			  var data = new google.visualization.DataTable();
		       data.addColumn('string', 'Month'); // Implicit domain column.
		       data.addColumn('number', '# of patches'); // Implicit data column.
		       data.addColumn('number', '# of TFT op.');
		       data.addColumn('number', '# of manual op.');
		       
		       var numberofLinkedDR= parseInt('${releaseManager.numberOfLinkedDr}');
		       
		       data.addRows(numberofLinkedDR);
		       
		       i= 0;
               <c:forEach items="${releaseManager.linkedDeploymentRequest}" var="deploymentRequest">
	               
	               nbrPatches = parseInt('${deploymentRequest.numberOfPatches}');
	               nbrOfTFTOp = parseInt('${deploymentRequest.numberOfTransferOperations}');
	               nbrManualOp = parseInt('${deploymentRequest.numberOfManualTransferOperations}');
		    	   
	               data.setCell(i,0, '${deploymentRequest.drName}');
	               data.setCell(i,1, nbrPatches);
		    	   data.setCell(i,2,nbrOfTFTOp);
		    	   data.setCell(i,3,nbrManualOp);
		    	   i++;
		       
		       </c:forEach>		       

        	 var options = {
        		      title : '${releaseManager.releaseName}:${releaseManager.synopsisOfRelease} ',
        		      vAxis: {title: 'Number of'},
        		      hAxis: {title: 'Deployment Requests'},
        		      seriesType: 'bars',
        		      //series: {5: {type: 'line'}}
        		    };
        	 var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
			 //var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        }
        
    
    chart.draw(data, options);
    }
    </script>
    <!--  Google chart -->

<div class="jumbotron">
<div class="panel-group">
<div class="panel panel-primary">  
    <div class = "panel-heading">Here below an overview of the release.</div>
    <div class="panel panel-info">
				<div class="panel-heading">
    <div class="row">
	<div class="col-md-8">
			<a class="btn btn-primary" href="${releaseManager.releaseName}.xls?releaseName=${releaseManager.releaseName}" role="button">Generate Excel</a>
	</div>
    </div>
    </div>
    </div>
 <div class = "panel-body"> 
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
</div> 
</div>
<div class="panel panel-info">
  <div class = "panel-heading">
      An overview of the release using Charts.
  </div>
<div id="chart_div" style="width: 900px; height: 500px;"></div>
</div>
</div>
</div>
<%@include file="includes/footer.jsp"%>
