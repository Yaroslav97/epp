package com.epam.poliakov.util.avatar;

import com.epam.poliakov.DAO.pool.PoolConnection;
import com.epam.poliakov.DAO.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static com.epam.poliakov.util.ContextTypeCons.CONTEXT_AVATAR_PATH;

@WebServlet("/avatar")
public class Avatar extends HttpServlet {

    private ComboPooledDataSource dataSource = PoolConnection.getPool();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        UserService userService = new UserService(dataSource);
        resp.setContentType("image/jpeg");
        String imageName = getServletContext().getInitParameter(CONTEXT_AVATAR_PATH) +
                userService.getUser(req.getParameter("login")).getImageName();

        try (
                ServletOutputStream out = resp.getOutputStream();
                FileInputStream inputStream = new FileInputStream(imageName);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out)
        ) {
            int ch = 0;
            while ((ch = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
