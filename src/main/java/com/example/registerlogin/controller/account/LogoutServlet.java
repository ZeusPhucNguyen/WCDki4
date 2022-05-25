package com.example.registerlogin.controller.account;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("currentLogin");
        resp.sendRedirect("/login");
    }

}
