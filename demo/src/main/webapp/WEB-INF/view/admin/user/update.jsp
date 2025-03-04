<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Update user</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

                <style>
                    /* .container {
                    background-color: rgb(53, 36, 14);
                    width: 50%;
                    height: 100%;
                    padding: 3% 0 0 0;
                } */

                    hr {
                        background-color: bisque;
                        height: 3px;
                    }
                </style>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update user</h3>
                            <hr />
                            <form:form action="/admin/user/update" method="post" modelAttribute="newUser">
                                <div class="mb-3" style="display: none;">
                                    <label for="form-label">ID:</label>
                                    <form:input type="text" class="form-control" path="id" />
                                </div>
                                <div class="mb-3">
                                    <label for="form-label">Email:</label>
                                    <form:input type="email" class="form-control" path="email" disabled="true" />
                                </div>
                                <div class="mb-3">
                                    <label for="form-label">Full name:</label>
                                    <form:input type="text" class="form-control" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label for="form-label">Address: </label>
                                    <form:input type="text" class="form-control" path="address" />
                                </div>
                                <div class="mb-3">
                                    <label for="form-label">Phone number</label>
                                    <form:input type="text" class="form-control" path="phone" />
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                            </form:form>
                        </div>
            </body>