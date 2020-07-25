<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="${Root}/home">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">About</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Contact</a>
  </li>
  
   <security:authorize access="isAuthenticated()">
  <li class="nav-item">
    <a class="nav-link disabled" href="${Root}/managebooks">Organize/Add to Shelf</a>
  </li>
  </security:authorize>
  
  <security:authorize access="isAnonymous()">
  <li class="nav-item">
    <a class="nav-link disabled" href="${Root}/login">Login</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="${Root}/signup">Sign Up</a>
  </li>
  </security:authorize>
</ul>