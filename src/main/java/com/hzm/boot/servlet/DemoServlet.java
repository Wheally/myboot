package com.hzm.boot.servlet;

import com.hzm.boot.api.HelloAPI;
import com.hzm.boot.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @desc springboot集成servlet
 * Created by WXQ on 2016/10/19.
 */
@WebServlet(urlPatterns="/demoServlet/*", description="Servlet的说明")
public class DemoServlet extends HttpServlet{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HelloAPI helloAPI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        User user = helloAPI.getUser(Integer.parseInt(userId));
        String userName = "";
        if(user != null){
            userName = user.getName();
        }
        logger.info(">>>>>>>>>>doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello "+ userName +"</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：demoServlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
