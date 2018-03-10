<%@include file="includes/header.jsp"%>	


<div class="jumbotron">
<div class="panel-group">
<div class="panel panel-primary">
  <div class = "panel-heading">
        Enter DB member name <i>[Member Name, GROUP, TYPE, COMPANY]</i>
    </div> 
    <div class = "panel-body">
  <!-- <form class="form-horizontal" role="form"> -->
  <form:form class="form-horizontal"  method="post" modelAttribute="member_description">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Member Name:</label>
      <div class="col-sm-2">          
        <!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password">-->
        <form:input path="name" class="form-control" placeholder="Enter Member Name here"/>
      </div>
      <div class="col-sm-2">          
        <!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password">-->
        <form:input path="group" class="form-control" placeholder="Enter Group Name here"/>
      </div>
      
      <div class="col-sm-2">          
        <!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password">-->
        <form:input path="type" class="form-control" placeholder="type "/>
      </div>
      
            <div class="col-sm-2">          
        <!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password">-->
        <form:input path="companyId" class="form-control" placeholder="Enter company Id "/>
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