public class LoggingInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
        String uri = req.getRequestURI();
        String user = (req.getSession().getAttribute("studentName") != null) ? req.getSession().getAttribute("studentName").toString() : "Guest";

        if (uri.contains("/login") && req.getMethod().equalsIgnoreCase("POST"))
            System.out.println("Login attempt: " + req.getParameter("email"));

        if (uri.contains("/register"))
            System.out.println("Registration by " + user + " to " + uri);

        return true;
    }
}

