import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JerseyApplication {



  private static Server createHttpServerJetty(Integer portOfListen){
    Server server = new Server(portOfListen);
    ServletContextHandler ctx = new ServletContextHandler();
    server.setHandler(ctx);
    ServletHolder servletHolder = ctx.addServlet(ServletContainer.class,"/*");
    servletHolder.setInitOrder(1);
    servletHolder.setInitParameter("jersey.config.server.provider.packages","resource");
    return server;
  }

  public static void main(String[] args) throws Exception {
    Integer portOfListen = 8087;
    Server server = createHttpServerJetty(portOfListen);
    server.start();
    server.join();
  }
}
