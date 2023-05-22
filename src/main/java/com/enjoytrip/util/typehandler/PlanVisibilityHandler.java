package com.enjoytrip.util.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.enjoytrip.dto.plan.PlanVisibility;

import org.apache.ibatis.type.BaseTypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(PlanVisibility.class)
public class PlanVisibilityHandler extends BaseTypeHandler<PlanVisibility> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, PlanVisibility parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setString(i, parameter.name());
  }

  @Override
  public PlanVisibility getNullableResult(ResultSet rs, String columnName) throws SQLException {
    String name = rs.getString(columnName);
    return name == null ? null : PlanVisibility.valueOf(name);
  }

  @Override
  public PlanVisibility getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String name = rs.getString(columnIndex);
    return name == null ? null : PlanVisibility.valueOf(name);
  }

  @Override
  public PlanVisibility getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String name = cs.getString(columnIndex);
    return name == null ? null : PlanVisibility.valueOf(name);
  }
}