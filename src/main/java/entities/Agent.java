package entities;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Gabriel Gutierrez on 10/29/2016.
 */
public class Agent extends Account {
    public Agent(String username, String password, Date c_date) throws SQLException {
        super(username, password, c_date);
    }
}
