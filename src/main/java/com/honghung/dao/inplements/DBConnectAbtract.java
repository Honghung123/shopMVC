package com.honghung.dao.inplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectAbtract {
    protected Connection conn = null;
    protected PreparedStatement preparedStmt = null;
    protected ResultSet resultSet = null;
}
