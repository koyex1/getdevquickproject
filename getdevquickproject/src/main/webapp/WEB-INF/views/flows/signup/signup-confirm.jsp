<%@include file="../shared/flows-header.jsp" %>
<div class="container">
<dl class="row">
  <dt class="col-sm-3">First Name</dt>
  <dd class="col-sm-9">${registerModel.user.firstName}</dd>
  
    <dt class="col-sm-3">Last Name</dt>
  <dd class="col-sm-9">${registerModel.user.lastName}</dd>
  
    <dt class="col-sm-3">Email</dt>
  <dd class="col-sm-9">${registerModel.user.email}</dd>
  
  <a href="${flowExecutionUrl}&_eventId_info" type="submit" class="btn btn-success">
  <span class="glyphicon  glyphicon-pencil" aria-hidden="true"></span> Edit
  </a>
      
</dl>
<div class="btn-group" role="group" aria-label="...">
 
   <a href="${flowExecutionUrl}&_eventId_complete" type="submit" class="btn btn-success">Submit
  <span class="glyphicon  glyphicon-chevron-right" aria-hidden="true"></span> 
  </a>
  </div>
  </div>
<%@include file="../shared/flows-footer.jsp" %>
