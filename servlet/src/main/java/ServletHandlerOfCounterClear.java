import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/counter/clear")
public class ServletHandlerOfCounterClear extends HttpServlet {

    public String findCookiesAndGetValue(Cookie[] cookies, String cookieName){

        if ((cookies != null)&&(cookieName != null)){
            for (Cookie cookieTemp: cookies){
                if(cookieName.equals(cookieTemp.getName())){
                    return cookieTemp.getValue();
                }
            }
        }
        return null;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieValue = findCookiesAndGetValue(request.getCookies(),"hh-auth");
        if((cookieValue != null)&&(cookieValue.length() > 10)) ServletApplication.counter.clearCounter();

    }

}
