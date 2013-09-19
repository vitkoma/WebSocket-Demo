<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Chat (WebSocket Test)</title>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

    <script type="text/javascript" src="chat.js"></script>
  </head>

  <body>
    <h1>Chat</h1>

    <div class="row">
      <div id="login" class="well col-md-4">
          <input id="nameField" name="name" class="form-control"/>
          <button onclick="login()" type="button" class="btn btn-primary">Login</button>
      </div>
    </div>

    <div class="row">
      <form action="" role="form" class="well col-md-4">
          <input id="messField" name="mess" class="form-control"/>
          <button onclick="sendMessage()" type="button"class="btn btn-primary">Send</button>
      </form>
    </div>

    <div class="row">
        <div id="output" class="col-md-4"></div>
    </div>

  </body>
</html>