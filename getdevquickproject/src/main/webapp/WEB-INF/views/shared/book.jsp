<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="col">
 
  <div class="col-md-4 col-md-4">
    <div class="thumbnail">
      <img src="..." alt="...">
      <div class="caption">
        <h3>${name}</h3>
        <p>${description}</p>
        <p>${rating}</p>
        <h4>${author}</h4>
        <h4>${genre}</h4>
<!--  <form 
	  action="${Root}/book/${item.id}"
	  method="POST">
  	  <select name="rating">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
      </select>
      <button type="submit">Submit</button>
      <input type="hidden" name="title"/>
      <input type="hidden" name="user"/>
      
      </form>    -->
      </div>
    </div>
  </div>
  
</div>