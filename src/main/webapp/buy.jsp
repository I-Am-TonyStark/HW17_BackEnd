<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Buy"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Buy page</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link href="style_1.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<div class="main-block">
    <h1>Buy Ticket</h1>
    <form name="buy_ticket" method="get" action="/OnlineBusReservation/filter/buy">
        <div class="formcontainer">
            <div class="container">
                <input type="number" name="travel_ID" hidden readonly value="<%=request.getParameter("travel_ID")%>">
                <table border="1" cellpadding="5" cellspacing="5">
                    <tbody>

                    <tr>
                        <td>FullName</td>
                        <td><input style="width: 100%" type="text" name="passenger_name" required></td>
                    </tr>

                    <tr>
                        <td>Gender</td>
                        <td>
                            <div class="radio_button">
                                <div>
                                    <label class="radio_label" for="male">Male</label>
                                    <input type="radio" name="gender" id="male" value="MALE" required/></div>
                                <div>
                                    <label class="radio_label" for="female">Female</label>
                                    <input type="radio" name="gender" id="female" value="FEMALE" required/>
                                </div>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <button type="submit"><strong>Buy</strong></button>
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </form>
</div>
</body>
</html>