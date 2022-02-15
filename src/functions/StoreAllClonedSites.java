package functions;

import customs.OutputMessageTypes;
import utils.MessageHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StoreAllClonedSites {
    public static void storeIntoDatabase(String visitedSite) throws IOException {
        String url = "jdbc:mysql://localhost:3306/clonedsitesdb?characterEncoding=utf8";
        String username = "root";
        String password = "pass@mysql";
        Connection conn = null;
        Statement statement = null;
        String sitename = visitedSite.split("//")[1];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS SitesCloned (SiteID int AUTO_INCREMENT PRIMARY KEY, SiteName VARCHAR(255) NOT NULL, SiteURL VARCHAR(255) NOT NULL, CloningDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP);");
                statement.execute("INSERT INTO SitesCloned (SiteName, SiteURL) VALUES ("+sitename.split(".")[0]+","+visitedSite+")");
            } else {
                MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, "Connection establishment failed!");
            }

        } catch (Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
    }
}
