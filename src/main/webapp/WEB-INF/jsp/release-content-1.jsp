<%@include file="includes/header.jsp"%>


<div class="jumbotron">
	<div class="panel-group">
		<div class="panel panel-primary">
			<div class="panel-heading">Release content generator.</div>
			<div class="panel panel-info">
				<div class="panel-heading">
				           Enter the DR name to generate a full release content 
				           (Patch list, transfer op. DB members, Synergy object etc.)
				</div>
				<div class="panel-body">
					<form:form class="form-horizontal" method="post"
						modelAttribute="releaseManager">
						<div class="form-group">
							<label class="control-label col-sm-2" for="releaseName">DR
								Name:</label>
							<div class="col-sm-4">
								<!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password">-->
								<form:input path="releaseName" class="form-control"
									placeholder="Enter DR name here" />
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
</div>
<%@include file="includes/footer.jsp"%>