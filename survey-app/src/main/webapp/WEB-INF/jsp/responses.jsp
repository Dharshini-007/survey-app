<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

    <title>Survey Result Analysis</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <h1 class="text-center text-primary mb-4">
        Survey Result Analysis
    </h1>

    <div class="card shadow p-4">

        <table class="table table-bordered table-hover">

            <thead class="table-dark">

                <tr>
                    <th>ID</th>
                    <th>Question</th>
                    <th>Answer</th>
                </tr>

            </thead>

            <tbody>

                <c:forEach var="response" items="${responses}">

                    <tr>

                        <td>${response.id}</td>

                        <td>${response.question.questionText}</td>

                        <td>${response.answer}</td>

                    </tr>

                </c:forEach>

            </tbody>

        </table>

        <div class="text-center mt-3">

            <a href="/surveys"
               class="btn btn-secondary">

                Back to Surveys

            </a>

        </div>

    </div>

</div>

</body>
</html>