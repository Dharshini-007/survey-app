<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

    <title>Available Surveys</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <h1 class="text-center text-primary mb-4">
        Available Surveys
    </h1>

    <div class="row">

        <c:forEach var="survey" items="${surveys}">

            <div class="col-md-6 mb-4">

                <div class="card shadow">

                    <div class="card-body">

                        <h3 class="card-title">
                            ${survey.title}
                        </h3>

                        <a href="/survey/${survey.id}"
                           class="btn btn-success mt-3">

                            Take Survey

                        </a>

                    </div>

                </div>

            </div>

        </c:forEach>

    </div>

</div>

</body>
</html>