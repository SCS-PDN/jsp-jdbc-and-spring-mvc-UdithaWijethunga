<form action="login" method="post">
    Email: <input type="email" name="email" /><br>
    Password: <input type="password" name="password" /><br>
    <input type="submit" value="Login" />
    <c:if test="${not empty error}">
      <p style="color:red">${error}</p>
    </c:if>
  </form>
  