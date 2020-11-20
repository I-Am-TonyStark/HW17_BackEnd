<%@ page import="com.mamalimomen.domains.City" %>
<%@ page import="com.mamalimomen.domains.Travel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Search"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Search page</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link href="style_1.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<%!

%>
<div class="main-block">
    <h1>Search Travel</h1>
    <hr>
    <form name="search" method="get"
          action="<%--${pageContext.request.contextPath}--%>/OnlineBusReservation/filter/search">
        <div class="formcontainer">
            <div class="container">
                <input list="cities" name="origin_cities" placeholder="Origin city" required="required">
                <input list="cities" name="dest_cities" placeholder="Destination city" required="required">

                <datalist name="cities" id="cities">
                    <% try {
                        City[] cities = (City[]) session.getAttribute("cities");
                        for (int i = 0; i < cities.length; i++) {%>
                    <option value="<%=cities[i]%>"><%=cities[i].toString().toUpperCase()%>
                    </option>
                    <%
                            }
                        } catch (NullPointerException e) {
                            response.sendRedirect("login.jsp");
                        }
                    %>
                </datalist>

                <input type="date" name="date" required>
            </div>
            <% String message = (String) session.getAttribute("search_message");
                if (message != null) { %>
            <hr>
            <h6><%=message%>
            </h6>
            <hr>
            <%}%>
            <button type="submit"><strong>Search</strong></button>
        </div>
    </form>

    <% List<Travel> travels = (List<Travel>) session.getAttribute("travels");
        if (travels != null && !travels.isEmpty()) {%>
    <hr/>

    <div class="box">
        <table border="1" cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th colspan="2">Line: <%=travels.get(0).getOrigin()%>
                    - <%=travels.get(0).getDestination()%>
                </th>
                <th>Date: <%=travels.get(0).getTravelDate()%>
                </th>
            </tr>
            <tr>
                <th>Select</th>
                <th>Time</th>
                <th>Travel ID</th>
            </tr>
            </thead>
            <tbody>
            <% for (Travel travel : travels) {%>
            <form name="<%=travel.getId()%>" method="get" action="buy.jsp">
                <tr>
                    <td>
                        <button type="submit"><strong>Select</strong></button>
                    </td>
                    <td><%=travel.getTravelTime()%>
                    </td>
                    <td><input type="number" name="travel_ID" readonly value="<%=travel.getId()%>"></td>
                </tr>
            </form>
            <%}%>
            </tbody>
        </table>
    </div>

    <%}%>
</div>
</body>
</html>