package ling.originalSources;

import org.apache.derby.client.am.SqlException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurperAdminOper {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;
    DatabaseInformation databaseInformation = new DatabaseInformation();

    private static SurperAdminOper surperAdminOperInstance = null;

    private SurperAdminOper() {

    }

    public static SurperAdminOper getInstance() {
        if (surperAdminOperInstance == null) {
            surperAdminOperInstance = new SurperAdminOper();
        }
        return surperAdminOperInstance;
    }

    public boolean select(String s)//
    {
        boolean judge = false;
        try {
            conn = databaseInformation.getconn();
            sql = "select admin_key from surperadmin limit 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String ss = rs.getString(1);
                judge = ss.equals(s);
            }

        } catch (Exception e) {
            DebugPrint.DPrint(e);
        } finally {
            databaseInformation.close(conn, ps, rs);
        }
        return judge;
    }

    public String getKey() {
        String key = "";
        try {
            conn = databaseInformation.getconn();

            sql = "select admin_key from surperadmin limit 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                key = rs.getString(1);
            }
        } catch (Exception e) {

        }

        return key;


    }

    public void add(String s) {
        try {
            conn = databaseInformation.getconn();
            sql = "INSERT INTO surperadmin(admin_key)VALUES(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, s);
            int i = ps.executeUpdate();
            if (i != 0) {
                DebugPrint.DPrint("SurperAdminOper add success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseInformation.close(conn, ps, rs);
        }

    }

    public void set_surperadmin() {
        try {
            conn = databaseInformation.getconn();
            sql = "create table surperadmin(			\r\n" +
                    "admin_key varchar(64)PRIMARY KEY\r\n" +
                    ")";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            int t = ps.executeUpdate();
            DebugPrint.DPrint(t);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseInformation.close(conn, ps, rs);
        }
    }


}