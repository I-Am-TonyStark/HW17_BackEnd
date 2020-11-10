<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Result"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Result page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"/>
    <link rel="stylesheet" href="style_1.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">

</head>
<body>
<div class="main-block">
    <h1>Operation Result</h1>
    <form name="back_to_menu" method="get" action="/OnlineBusReservation/menu.jsp">
        <% String message = (String) request.getSession(false).getAttribute("message");
            if (message != null && !message.isEmpty()) { %>
        <h1><%=message%></h1>
        <%}%>
        <div class="btn-block">
            <button type="submit">Back To Menu</button>
        </div>
    </form>
</div>
</body>
</html>