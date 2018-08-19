package model.dao.statement;

public interface Statements {
    String AND = " AND ";
    String INSERT_USER_FIRST_LAST_MIDDLE_NAME_LOGIN_PASSWORD_ROLE = "INSERT INTO " + ColumName.USER_TABLE
            + "("
            + ColumName.USER_FIRST_NAME + ","
            + ColumName.USER_LAST_NAME + ","
            + ColumName.USER_MIDDLE_NAME + ","
            + ColumName.USER_LOGIN + ","
            + ColumName.USER_PASSWORD + ","
            + ColumName.USER_ROLE
            + ")"
            +" VALUES (?,?,?,?,?,?)";
    String SELECT_USER_BY_ID = "";

    String LOGIN_BY_LOGIN_PASSWORD = "SELECT * FROM " + ColumName.USER_TABLE
            + " WHERE "
            + ColumName.USER_LOGIN + " = ? "
            + AND
            + ColumName.USER_PASSWORD + " = ?";
}
