<div >
<ul class="nav nav-pills">
<c:forEach items= "${genres}" var= "item">
  <li class="nav-item">
  
    <a class="nav-link disabled" href="#">${item.name}</a>
  

  </li>
  </c:forEach>
</ul>
</div>