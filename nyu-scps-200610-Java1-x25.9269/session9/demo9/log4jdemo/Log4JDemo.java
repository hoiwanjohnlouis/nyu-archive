import org.apache.log4j.Logger;

public class Log4JDemo {
      static Logger log = Logger.getLogger("Log4jDemo");

      public static void main(String args[]) {
            log.debug("This is my debug message.");
            log.info("This is my info message.");
            log.warn("This is my warn message.");
            log.error("This is my error message.");
            log.fatal("This is my fatal message.");
      }
}
