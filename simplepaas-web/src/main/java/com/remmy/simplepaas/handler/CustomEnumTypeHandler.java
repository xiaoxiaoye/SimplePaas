package com.remmy.simplepaas.handler;

import com.remmy.simplepaas.dto.DeployMode;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yejiaxin
 */
public class CustomEnumTypeHandler extends BaseTypeHandler<DeployMode> {
    private final Map<String, DeployMode> enumMap;

    public CustomEnumTypeHandler() {
        this.enumMap = new HashMap<>();
        for (DeployMode mode : DeployMode.values()) {
            enumMap.put(mode.getMode(), mode);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DeployMode parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getMode());
    }

    @Override
    public DeployMode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s == null ? null : this.enumMap.get(s);
    }

    @Override
    public DeployMode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s == null ? null : this.enumMap.get(s);
    }

    @Override
    public DeployMode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s == null ? null : this.enumMap.get(s);
    }
}
