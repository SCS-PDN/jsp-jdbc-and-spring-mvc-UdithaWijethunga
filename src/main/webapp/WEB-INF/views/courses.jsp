<h2>Available Courses</h2>
<c:forEach var="c" items="${courses}">
  <div>
    ${c.name} by ${c.instructor} (${c.credits} credits)
    <form method="post" action="register/${c.course_id}">
      <button type="submit">Register</button>
    </form>
  </div>
</c:forEach>
