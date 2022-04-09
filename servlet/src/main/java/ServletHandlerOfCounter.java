import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/counter")
public class ServletHandlerOfCounter extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        Cookie counterCookie = new Cookie("hh-auth","newvasuki-newvasuki");
        response.addCookie(counterCookie);

        try{
            writer.println("<h2>Counter = " + ServletApplication.counter.getCounter() + "</h2>");
        }
        finally {
            writer.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ServletApplication.counter.postCounter();

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try{
            Integer subtractionValue = Integer.parseInt(request.getParameter("Subtraction-Value"));
            ServletApplication.counter.deleteCounter(subtractionValue);
        }
        catch (Exception e){

        }
    }


}
