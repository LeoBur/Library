<%@ include file="/taglibs.jsp"%>

<title><fmt:message key="bookList.title"/></title>

<button onclick="location.href='bookForm'" style="float: right; margin-top: -30px; width: 100px">Manage Books</button>

<display:table name="bookList" class="table" requestURI="books" id="bookList" export="true" pagesize="10" excludedParams="ajax">
    <display:setProperty name="export.pdf.filename" value="books.pdf"/>
    <display:column property="id" sortable="true" href="bookForm" media="html"
        paramId="id" paramProperty="id" titleKey="book.isbn"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="book.isbn"/>
    <display:column property="title" sortable="true" titleKey="book.title" escapeXml="true"/>
    <display:column property="author" sortable="true" titleKey="book.author" escapeXml="true"/>
</display:table>

<script type="text/javascript">highlightTableRows("bookList");</script>