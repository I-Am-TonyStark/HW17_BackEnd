<%@ page import="com.mamalimomen.domains.City" %>
<%@ page import="com.mamalimomen.domains.Travel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mamalimomen.domains.Ticket" %>
<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="See Tickets"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>See tickets page</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link href="style_1.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="main-block">
    <h1>See Tickets</h1>
    <% List<Ticket> tickets = (List<Ticket>) session.getAttribute("tickets");
        if (tickets != null && !tickets.isEmpty()) {%>
    <hr/>
    <div class="box">
        <table border="1" cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th colspan="3">Your bought Tickets list</th>
            </tr>
            <tr>
                <th>Select</th>
                <th>Ticket ID</th>
                <th>Travel Date</th>
            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < tickets.size(); i++) {
                Ticket ticket = tickets.get(i);
            %>
            <tr>
                <td>
                    <a onclick="linkToggle(<%=i%>)"><strong>See Ticket</strong></a>
                </td>
                <td><%=ticket.getId()%>
                </td>
                <td><%=ticket.getTravel().getTravelDate()%>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <%} else {%>
    <hr>
    <h6>You have not any Ticket yet!</h6>
    <hr>
    <%}%>

    <% for (int i = 0; i < tickets.size(); i++) {
        Ticket ticket = tickets.get(i);
        Travel travel = ticket.getTravel();
    %>
    <div id="<%=i%>" style="display: none">
        <form name="cancel" method="get" action="/OnlineBusReservation/filter/cancel">
            <div class="formcontainer">
                <div class="container">
                    <input type="number" name="ticket_ID" value="<%=ticket.getId()%>" hidden readonly>
                    <table border="1" cellpadding="5" cellspacing="5">
                        <thead>
                        <tr>
                            <th colspan="2">Bus Ticket</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td>Ticket ID</td>
                            <td><%=ticket.getId()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Full Name</td>
                            <td><%=ticket.getOwnerFullName()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Gender</td>
                            <td><%=ticket.getGender()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Origin</td>
                            <td><%=travel.getOrigin()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Destination</td>
                            <td><%=travel.getDestination()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Date</td>
                            <td><%=travel.getTravelDate()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Time</td>
                            <td><%=travel.getTravelTime()%>
                            </td>
                        </tr>

                        <tr>
                            <td>Travel ID</td>
                            <td><%=travel.getId()%>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <button type="submit">Cancel Ticket</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
        <%}%>
    </div>
</div>
<script>
    function linkToggle(index) {
        let link = document.getElementById(index);
        if (link.style.display === "none") {
            link.style.display = "block";
        } else {
            link.style.display = "none";
        }
    }
</script>
</body>
</html>