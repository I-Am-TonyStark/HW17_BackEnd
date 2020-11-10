<%@ page import="com.mamalimomen.domains.City" %>
<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Create"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Create travel page</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link href="style_1.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="main-block">
    <h1>Create Travel</h1>
    <form name="sign_up" method="post" action="/OnlineBusReservation/filter/security/create">
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

                <input type="date" placeholder="Travel Date" name="date" required>
                <input type="time" placeholder="Travel Time" name="time" required>
            </div>
            <% String message = (String) request.getAttribute("message");
                if (message != null) { %>
            <hr>
            <h6><%=message%>
            </h6>
            <hr>
            <%}%>
            <button type="submit"><strong>Create</strong></button>
        </div>
    </form>
</div>
</body>
</html>