<!-- < % @ include file="/views/include.jsp" % > -->
<!-- <html> -->
<!--   <head><title> ::: Spring App 3.2.1 >> Hello.jsp</title></head> -->
<!--   <body> -->
<!--     <h1>Hello - Spring Application</h1> -->
<!--     <p>Greetings.</p> -->
<!--     <p>Tony Stark is in the house :)</p> -->
<%--     <p>Greetings, it is now <c:out value="${now}"/></p> --%>
<!--   </body> -->
<!-- </html> -->

<%@ include file="/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Tony Stark is in the house :)</h3>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.descripcion}"/> <i>$<c:out value="${prod.precio}"/></i><br><br>
    </c:forEach>
    
    <br>
    <a href="<c:url value="priceincrease.htm"/>"> >>>>  Increase Prices  >>>> </a>
    <br>
    
  </body>
</html>





