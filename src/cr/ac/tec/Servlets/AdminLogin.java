package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.Accounts.User;
import cr.ac.tec.SavedInfo.UsersTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

/**
 *
 */
@WebServlet("/Adminlog")
public class AdminLogin extends HttpServlet {
    private final String username="adminUsername";
    private final String password="adminPassword";
    private final String AdminPassword="admin";
    private final String AdminPassword2="user";

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserName=req.getParameter(username);
        String Password=req.getParameter(password);
        //User user=new User(userID);
        //UsersTree tree=UsersTree.getInstance();
        //tree.attach(user);
        //user=tree.getMember(user);
        //resp.getWriter().print(user.getID());

        if((UserName.equals(AdminPassword) && Password.equals(AdminPassword))||(UserName.equals(AdminPassword2) && Password.equals(AdminPassword2))){

            resp.sendRedirect("Admin.jsp");
        }
        else{
            resp.sendRedirect("AdminLogin.jsp");
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
