package com.epam.poliakov.DAO.transactionManager;

import java.sql.Connection;
import java.sql.SQLException;

public interface TransactionOperation<T> {

    T operation(Connection connection) throws SQLException;
}
