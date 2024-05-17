
package org.luishernandez.webapp.compra;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lphg3
 */

@WebServlet("/compra")
public class ComprasServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       String email = req.getParameter("email");
       
       List <String> errores = new ArrayList<>();
       
       if (username == null || username.isBlank()){
           errores.add("el username es requerido");
       }
       if (password == null || password.isBlank()){
           errores.add("el passsword no puede ser vacio");
       }
       if(email == null || !email.contains("@") ){
           errores.add("el email es requerido y debe tener un formato de correo");
       }
       
       try(PrintWriter out = resp.getWriter()){
            out.println("</DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\" >");
            out.println("        <title>Resultado Form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Resultados de compra</h1>");
            
            out.println("           <ul>");
            if (errores.isEmpty()){
            out.println("               <li> Username: " + username + "</li>");
            out.println("               <li> Password: " + password + "</li>");
            out.println("               <li> Email: " + email + "</li>");
            }else {
                errores.forEach(error -> {
                    out.println("<li>"+ error +"</li>");
                   
            });
                out.println("<p><a href= \"/webApp-Compra/index.html\"");
            }
            out.println("           </ul>");
            out.println("    </body>");
            out.println("</hmtl>");
       
       }
    }
        
}
