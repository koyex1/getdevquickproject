<div >
 <c:forEach items="${books}" var="item" >  
 <a href="${Root}/book/${item.id}"><img src="..." alt="..." class="img-thumbnail">${item.name}</a>
 </c:forEach>
</div>