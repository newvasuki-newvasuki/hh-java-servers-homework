import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.http.HttpServlet;

public class ServletApplication {

  public static Counter counter = new Counter();

  private static Server createHttpServer(Integer portOfListen){
    Server httpServer = new Server(portOfListen);
    ServletHandler servletHandler = new ServletHandler();
    servletHandler.addServletWithMapping(ServletHandlerOfCounter.class,"/counter");
    servletHandler.addServletWithMapping(ServletHandlerOfCounterClear.class,"/counter/clear");
    httpServer.setHandler(servletHandler);
    return httpServer;
  }

  public static void main(String[] args) throws Exception {
    int port = 8081;
    Server server = createHttpServer(port);
    server.start();
    server.join();
  }
}
