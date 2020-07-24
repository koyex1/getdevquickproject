<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<c:if test="${not empty operation}">
<div class="alert alert-success glyphicon glyphicon-ok-circle" role="alert">
 ${operation}
</div>
</c:if>


<div class="container">
<sf:form modelAttribute="book"
action="${Root}/managebooks"
method="POST"
>
  <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Book Title</label>
    <div class="col-sm-10">
      <sf:input path="name" type="text" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Book Title"/>
    </div>
  </div>
  <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Author</label>
    <div class="col-sm-10">
      <sf:input path="author" type="text" class="form-control form-control-sm" id="colFormLabelSm" placeholder="Author"/>
    </div>
  </div>
  <div class="form-group row">
    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Genre</label>
    <div class="col-sm-10">
    <sf:select path="genreId" class="form-control" id="exampleFormControlSelect1"
     items="${genres}"
     itemLabel="name"
     itemValue="id"
    />
   </div>
  </div>
  
   <div class="form-group row">
    <label for="exampleFormControlTextarea1" class="col-sm-2 col-form-label col-form-label-sm">Description</label>
     <div class="col-sm-10">
    <sf:textarea path="description" class="form-control form-control-sm" id="colFormLabelSm"  rows="4"/>
  </div>
  </div>
  
  <button type="submit" class="btn btn-success">
  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Add to Shelf
  </button>
  
  <!-- HIDDEN -->
  <sf:input path="rating" type="hidden"/>
   <sf:input path="active" type="hidden"/>
   
</sf:form>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Title</th>
      <th scope="col">Description</th>
      <th scope="col">Author</th>
      <th scope="col">Rating</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${books}" var="item">
    <tr>
   
      <td>${item.name }</td>
      <td>${item.description }</td>
       <td>${item.author}</td>
       <td>${item.rating}</td>
<td>
	<a href="${Root}/managebooks/${item.id}/edit" class="btn btn-primary">
	<span class="glyphicon glyphicon-pencil"></span>
	Organize</a>
</td>

<td>
	<a href="${Root}/managebooks/${item.id}/delete" class="btn btn-danger">
	<span class="glyphicon glyphicon-trash"></span>
	Remove</a>
</td>

    </tr>
      </c:forEach>
 
    
  </tbody>
</table>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


</div>