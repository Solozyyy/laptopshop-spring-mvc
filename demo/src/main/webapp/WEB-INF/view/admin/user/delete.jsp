<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                <title>Delete user ${id}</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="md-col-10 col-12 mx-auto">
                            <h3>Delete user id = ${id}</h3>
                            <hr />
                            <div class="alert alert-danger" role="alert">
                                Are you sure to delete this user?
                            </div>
                            <form:form action="/admin/user/delete" method="post" modelAttribute="deleteUser">
                                <div class="mb-3" style="display: none;">
                                    <label for="form-label">ID:</label>
                                    <form:input type="text" value="${id}" class="form-control" path="id" />
                                </div>
                                <button type="submit" class="btn btn-danger">Confirm</button>
                            </form:form>
                        </div>
            </body>