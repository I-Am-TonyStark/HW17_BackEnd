<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Menu"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Menu page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"/>
    <link rel="stylesheet" href="style_1.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>

<%--&nbsp;--%>
<%--<jsp:include page="menu.jsp"></jsp:include>--%>
<div class="main-block">
    <h1>Menu</h1>
    <hr>
    <form name="option1" method="get" action="/OnlineBusReservation/search.jsp">
        <div class="btn-block">
            <button type="submit">Buy a Ticket</button>
        </div>
    </form>
    <form name="option2" method="get" action="/OnlineBusReservation/filter/see">
        <div class="btn-block">
            <button type="submit">See your Tickets</button>
        </div>
    </form>
    <form name="option3" method="get" action="/OnlineBusReservation/filter/logout">
        <div class="btn-block">
            <button type="submit">Logout</button>
        </div>
    </form>
    <br/>
    <% Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getValue().equals("Manager")) {%>
    <div class="center">
        <a href="/OnlineBusReservation/create.jsp">Create a Travel</a>
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>