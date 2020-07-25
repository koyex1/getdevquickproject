<%@include file="../shared/flows-header.jsp" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!-- has its own ${Root} ${flowExecutionUrl} -->
<div class="container">

<sf:form modelAttribute="user"
method="POST"
id="signForm"
>
  <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">First Name</label>
    <div class="col-sm-10">
      <sf:input path="firstName" type="text" class="form-control form-control-sm" id="colFormLabelSm" placeholder="First Name"/>
    </div>
  </div>
  <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Last Name</label>
    <div class="col-sm-10">
      <sf:input path="lastName" type="text" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Last Name"/>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Email</label>
    <div class="col-sm-10">
      <sf:input path="email" type="text" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Email"/>
    </div>
  </div>
  
   <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Password</label>
    <div class="col-sm-10">
      <sf:input path="password" type="text" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Password"/>
    </div>
  </div>
  
  <button name="_eventId_confirm" type="submit" class="btn btn-success">Confirm
  <span class="glyphicon  glyphicon-chevron-right" aria-hidden="true"></span> 
  </button>
</sf:form>


</div>

<%@include file="../shared/flows-footer.jsp" %>

