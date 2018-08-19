package model.dao.statement;

public interface Statements {
    String INSERT_USER_FIRST_LAST_MIDDLE_NAME_LOGIN_PASSWORD = "INSERT INTO "+ColumName.USER_TABLE+
            "("
            + ColumName.USER_FIRST_NAME+","
            + ColumName.USER_LAST_NAME+","
            + ColumName.USER_MIDDLE_NAME+","
            + ColumName.USER_LOGIN+","
            + ColumName.USER_PASSWORD
            +")"
            +"VALUES (?,?,?,?,?)";
    String SELECT_USER_BY_ID = "";
}
