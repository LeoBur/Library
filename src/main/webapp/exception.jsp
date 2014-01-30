<<%@ include file="/taglibs.jsp" %>

 <h3>Problem</h3>
 <p>
     <c:out value="${requestScope.exception.message}"/>
 </p>

 <!--
 <%
 Exception ex = (Exception) request.getAttribute("exception");
 String message = requestScope.exception.message;

 %>
 -->

 <a href="<c:url value='/'/>">&#171; Home</a>
