<%@ page import="java.util.HashMap" %>
    <!DOCTYPE html>
    <html lang="en">

    <!-- header -->
    <%@ include file="/WEB-INF/views/templates/header.jsp" %>

    <body>
                <!-- Menu -->
                <%@ include file="/WEB-INF/views/templates/navigator.jsp" %>
        <main class="container">
            <% HashMap result=(HashMap) request.getAttribute("result"); %>

                <h2>
                    <%= result.get("TITLE") %>
                </h2>
                <form action="">
                    <div class="mb-3">
                        <label>WIRTE_ID:</label>
                        <%= result.get("WRITER_ID") %>
                    </div>
                    <div class="mb-3">
                        <label> CREATE_DATE </label>
                        <%= result.get("CREATE_DATE") %>
                    </div>
                    <div class="mb-3">
                        <label>CATEGORY : </label>
                        <%= result.get("PARENT_BOARDS") %>
                    </div>
                    <div class="mb-3">
                        <label>CONTENTS:</label>
                        <textarea class="form-control" rows="5" id="comment" name="text" readonly>
                    <%= result.get("CONTENTS") %>
                </textarea>
                    </div>
                    <input type="hidden" class="form-check-input" name="deleteIds"
                        value='<%= result.get("PK_BOARDS") %>'>
                        <input type="hidden" class="form-check-input" name="PK_BOARDS"
                        value='<%= result.get("PK_BOARDS") %>'>
                    <button type="submit" class="btn btn-primary" formaction="/q/board/list_pagination"
                        formmethod="get">List</button>
                    <button type="submit" class="btn btn-danger" formaction="/q/board/list_pagination" name="btn_type"
                        value="delete" formmethod="get">Delete</button>
                    <button type="submit" class="btn btn-success" formaction="/q/board/update"
                        formmethod="get">UPDATE</button>
                </form>
        </main>
        <!-- Footer -->
        <%@ include file="/WEB-INF/views/templates/footer.jsp" %>
    </body>
    <!-- Latest compiled JavaScript -->

    </html>