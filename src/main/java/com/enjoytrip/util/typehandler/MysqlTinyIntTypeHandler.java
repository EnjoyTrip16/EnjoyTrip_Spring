package com.enjoytrip.util.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Boolean.class)
public class MysqlTinyIntTypeHandler extends BaseTypeHandler<Boolean> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
    ps.setByte(i, (byte) (parameter ? 1 : 0));
  }

  @Override
  public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
    byte b = rs.getByte(columnName);
    return b != 0;
  }

  @Override
  public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    byte b = rs.getByte(columnIndex);
    return b != 0;
  }

  @Override
  public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    byte b = cs.getByte(columnIndex);
    return b != 0;
  }
}