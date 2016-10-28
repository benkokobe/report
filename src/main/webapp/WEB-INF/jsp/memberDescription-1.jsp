<%@include file="includes/header.jsp"%>	


<div class="jumbotron">
  <h2>DB member Name.</h2>
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
<%@include file="includes/footer.jsp"%>