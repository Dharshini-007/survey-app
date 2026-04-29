<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

    <title>Take Survey</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4">

        <h1 class="text-center text-primary mb-4">
            ${survey.title}
        </h1>

        <form action="/submitSurvey" method="post">

            <c:forEach var="question" items="${survey.questions}">

                <div class="mb-4">

                    <label class="form-label fw-bold">
                        ${question.questionText}
                    </label>

                    <input type="hidden"
                           name="questionId"
                           value="${question.id}" />

                    <input type="text"
                           class="form-control"
                           name="answer"
                           placeholder="Enter your answer"
                           required />

                </div>

            </c:forEach>

            <div class="text-center">

                <button type="submit"
                        class="btn btn-primary btn-lg">

                    Submit Survey

                </button>

            </div>

        </form>

    </div>

</div>

</body>
</html>