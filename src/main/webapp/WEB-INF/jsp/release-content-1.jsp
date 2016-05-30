<%@include file="includes/header.jsp"%>	


<div class="jumbotron">
  <h2>Release content generator.</h2>
  <!-- <form class="form-horizontal" role="form"> -->
  <form:form class="form-horizontal"  method="post" modelAttribute="releaseManager">
    <div class="form-group">
      <label class="control-label col-sm-2" for="releaseName">DR Name:</label>
      <div class="col-sm-4">          
        <!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password">-->
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
<%@include file="includes/footer.jsp"%>