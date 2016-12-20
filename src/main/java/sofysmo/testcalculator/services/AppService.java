package sofysmo.testcalculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

/**
 * Created by sofysmo on 21.12.16.
 */
@Service
public class AppService {

    private Connection connection;

    @Autowired
    public AppService(Connection connection){

    }
}
