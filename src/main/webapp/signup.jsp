<%@ page contentType="text/html; ISO-8859-1;charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="SignUp"/>
    <meta name="keywords" content="HTML, CSS, Java, Servlet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>SignUp page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"/>
    <link rel="stylesheet" href="style_1.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">

</head>
<body>
<div class="main-block">
    <h1>SignUp</h1>
    <form name="signup" method="post" action="/OnlineBusReservation/signup">
        <hr>
        <label id="icon" for="username"><i class="fas fa-user"></i></label>
        <input type="text" name="username" id="username" placeholder="Username" required/>
        <label id="icon" for="password"><i class="fas fa-unlock-alt"></i></label>
        <input type="password" name="password" id="password" placeholder="Password" required/>
        <hr>
        <% String message = (String) request.getAttribute("message");
            if (message != null && !message.isEmpty()) { %>
        <h6><%=message%>
        </h6>
        <hr>
        <%}%>
        <div class="btn-block">
            <button type="submit">Login</button>
        </div>
    </form>
</div>
</body>
</html>