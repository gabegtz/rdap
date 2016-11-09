package entities;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by sgduong on 11/3/2016.
 */
public class Director extends Account {
    public Director(String username, String password, Date c_date) throws SQLException {
        super(username, password, c_date);
    }
}
