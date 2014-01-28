<%@ include file="/taglibs.jsp"%>

<head>
    <title><fmt:message key="bookForm.title"/></title>
</head>

<p>Please fill in book's information below:</p>

<form:form commandName="book" method="post" action="bookform" onsubmit="return validateBook(this)" id="bookForm">
<form:errors path="*" cssClass="error"/>
<form:hidden path="id"/>
<form:hidden path="version"/>
<table class="detail">
<tr>
    <th><label for="isbn"><fmt:message key="book.isbn"/>:</label></th>
    <td>
        <form:input path="isbn" id="isbn"/>
        <form:errors path="isbn" cssClass="fieldError"/>
    </td>
</tr>
<tr>
    <th><label for="title">* <fmt:message key="book.title"/>:</label></th>
    <td>
        <form:input path="title" id="title"/>
        <form:errors path="title" cssClass="fieldError"/>
    </td>
</tr>
<tr>
    <th><label for="author" class="required"><fmt:message key="book.author"/>:</label></th>
    <td>
        <form:input path="author" id="author"/>
        <form:errors path="author" cssClass="fieldError"/>
    </td>
</tr>
<tr>
    <td></td>
    <td>
        <input type="submit" class="button" name="save" value="Save"/>
      <c:if test="${not empty param.isbn}">
      <security:authorize ifAllGranted="ROLE_ADMIN">
        <input type="submit" class="button" name="delete" value="Delete"/>
      </security:authorize>
      </c:if>
      	<input type="submit" class="button" name="cancel" value="Cancel" onclick="bCancel=true"/>
    </td>
</tr>
</table>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('bookForm'));
</script>

<v:javascript formName="book" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>