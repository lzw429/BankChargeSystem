package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginAuthServlet")
public class LoginAuthServlet extends BaseServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("登录验证：用户名 " + username + " 密码 " + password);

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if (user != null) { // 用户名密码匹配
            final int maxAge = 7 * 24 * 60 * 60;
            Cookie c_username = new Cookie("username", username);
            c_username.setMaxAge(maxAge);
            c_username.setPath("/");
            response.addCookie(c_username);
            // 首次登录成功后，将用户名保存到 session 中
            final int maxInactiveInterval = 7 * 24 * 60 * 60;
            session.setMaxInactiveInterval(maxInactiveInterval);
            session.setAttribute("user", user);
            // 将 JSESSIONID 持久化
            Cookie c_JSESSIONID = new Cookie("JSESSIONID", session.getId());
            c_JSESSIONID.setMaxAge(maxInactiveInterval);
            c_JSESSIONID.setPath("/");
            response.addCookie(c_JSESSIONID);
            // 登录成功后，请求 HomepageServlet 以跳转到个人主页
            response.setContentType("text/plain");
            response.getWriter().write("/customer");
        } else { // 用户名或密码错误
            response.sendError(403);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
