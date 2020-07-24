<div >
 <c:forEach items="${books}" var="item" >  
 <div class="col">
 <a href="${Root}/book/${item.id}">
  <div class="col-md-4 col-md-4">
    <div class="thumbnail">
      <img src="..." alt="...">
      <div class="caption">
        <h3>${item.name}</h3>
        <p>${item.description}</p>
        <h4>${item.genreId}</h4>
      </div>
    </div>
  </div>
  </a>
</div>
 </c:forEach>
</div>