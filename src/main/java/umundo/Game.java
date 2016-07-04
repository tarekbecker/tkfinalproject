package umundo;

import org.apache.log4j.Logger;
import umundo.control.Client;

public class Game {

  private static Logger log = Logger.getLogger(Game.class.getName());

  public static void main(String[] args) throws Exception {
    Class.forName("umundo.QuestionFactory");
    int port;
    try {
      port = Integer.parseInt(args[0]);
    } catch (IndexOutOfBoundsException e) {
      log.error("Please specify a port number for the web server.");
      System.exit(1);
      return;
    } catch (NumberFormatException e) {
      log.error("Error while parsing input port:" + e);
      System.exit(1);
      return;
    }
    new Client(port).run();
  }
}
