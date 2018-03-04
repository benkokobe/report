<%@include file="includes/header.jsp"%>	

<div class="jumbotron">
<div class="panel-group">
<div class="panel panel-primary">  
    <div class = "panel-heading">
        Click <li><a href="/release_checker">here</a></li> to get the last DR executed from PRG to BLD.
    </div>
  <div class="panel-body">The last DR that was executed from PRG to BLD and the corresponding environments where it's installed will be listed.
  </div>
  </div>
</div>
  
  <div class="panel panel-info">
  <div class = "panel-heading">
      You can also check a DR for to see in which environments it's installed.
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