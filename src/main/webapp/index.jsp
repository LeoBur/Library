<%@ include file="/taglibs.jsp"%>

<div id="intro">
    <h2>Welcome to Library</h2>
    <p>
        <button onclick="location.href='bookForm'" style="float: right; margin-top: -30px; width: 100px">Add Book</button>

        <display:table name="booklist" class="table" requestURI="books" id="bookList" export="true" pagesize="10" excludedParams="ajax">
            <display:setProperty name="export.pdf.filename" value="books.pdf"/>
            <display:column property="isbn" sortable="true" href="bookForm" media="html"
                paramId="isbn" paramProperty="id" titleKey="book.isbn"/>
            <display:column property="isbn" media="csv excel xml pdf" titleKey="book.isbn"/>
            <display:column property="title" sortable="true" titleKey="book.title" escapeXml="true"/>
            <display:column property="author" sortable="true" titleKey="book.author" escapeXml="true"/>
        </display:table>

        <script type="text/javascript">highlightTableRows("bookList");</script>
    </p>
</div>
</script>