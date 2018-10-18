/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import logic.entity.OrderAdmission;

/**
 *
 * @author Admin
 */
public class OrderAdmissionPhysfaceDAO {
    private ArrayList<OrderAdmission> allOrderList=new ArrayList<OrderAdmission>();
    private ArrayList<OrderAdmission> atParamsList=new ArrayList<OrderAdmission>();
    private Connection conn=null;
    private Statement stmt=null;
    private PreparedStatement prepstmt=null;
    private ResultSet rs=null;
    private ArrayList<OrderAdmission> getAllOrders() throws NamingException, SQLException{
        try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT orders_admission.OrderAdmission_ID, orders_admission.ContractsOrdersPhysfaces_ID, \n" +
"cources.Cource, orders_admission.DateBeginScience, orders_admission.DateEndScience, \n" +
"teachers.Teacher, orders_admission.StatusOrder_ID, status_orders.StatusOrder \n" +
"FROM orders_admission \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM app_teach \n" +
"WHERE AppTeach_ID=(SELECT AppTeach_ID FROM contracts_orders_physfaces \n" +
"WHERE ContractsOrdersPhysfaces_ID=orders_admission.ContractsOrdersPhysfaces_ID)) \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=orders_admission.Teacher_ID \n" +
"INNER JOIN status_orders ON status_orders.StatusOrder_ID=orders_admission.StatusOrder_ID");
            while(rs.next()){
                OrderAdmission order=new OrderAdmission();
                order.setOrderAdmission_ID(rs.getInt("OrderAdmission_ID"));
                order.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                order.setCource(rs.getString("Cource"));
                order.setDateBeginScience(rs.getDate("DateBeginScience"));
                order.setDateEndScience(rs.getDate("DateEndScience"));
                order.setTeacher(rs.getString("Teacher"));
                order.setStatusOrder_ID(rs.getInt("StatusOrder_ID"));
                order.setStatusOrder(rs.getString("StatusOrder"));
                allOrderList.add(order);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(OrderAdmissionYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return allOrderList;
    }
    public ArrayList<OrderAdmission> getAllOrderList() throws NamingException, SQLException{
        if(!allOrderList.isEmpty()){
            return allOrderList;
        } else {
            return getAllOrders();
        }
    }
    
    public ArrayList<OrderAdmission> getOrderListAtParams(String params) throws SQLException, NamingException{
          atParamsList.clear();
          try{
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT orders_admission.OrderAdmission_ID, orders_admission.ContractsOrdersPhysfaces_ID, \n" +
"cources.Cource, orders_admission.DateBeginScience, orders_admission.DateEndScience, \n" +
"teachers.Teacher, orders_admission.StatusOrder_ID, status_orders.StatusOrder \n" +
"FROM orders_admission \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM app_teach \n" +
"WHERE AppTeach_ID=(SELECT AppTeach_ID FROM contracts_orders_physfaces \n" +
"WHERE ContractsOrdersPhysfaces_ID=orders_admission.ContractsOrdersPhysfaces_ID)) \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=orders_admission.Teacher_ID \n" +
"INNER JOIN status_orders ON status_orders.StatusOrder_ID=orders_admission.StatusOrder_ID WHERE "+params);
            while(rs.next()){
                OrderAdmission order=new OrderAdmission();
                order.setOrderAdmission_ID(rs.getInt("OrderAdmission_ID"));
                order.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                order.setCource(rs.getString("Cource"));
                order.setDateBeginScience(rs.getDate("DateBeginScience"));
                order.setDateEndScience(rs.getDate("DateEndScience"));
                order.setTeacher(rs.getString("Teacher"));
                order.setStatusOrder_ID(rs.getInt("StatusOrder_ID"));
                order.setStatusOrder(rs.getString("StatusOrder"));
                atParamsList.add(order);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(OrderAdmissionYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(rs!=null) rs.close();
        }
        return atParamsList;
    }
    
    public OrderAdmission getOrderById(int id) throws SQLException, NamingException{
        OrderAdmission order=new OrderAdmission();
        try {
            conn=Database.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("SELECT orders_admission.OrderAdmission_ID, orders_admission.ContractsOrdersPhysfaces_ID, \n" +
"cources.Cource, orders_admission.DateBeginScience, orders_admission.DateEndScience, \n" +
"teachers.Teacher, orders_admission.StatusOrder_ID, status_orders.StatusOrder \n" +
"FROM orders_admission \n" +
"INNER JOIN cources ON cources.Cource_ID=(SELECT Cource_ID FROM app_teach \n" +
"WHERE AppTeach_ID=(SELECT AppTeach_ID FROM contracts_orders_physfaces \n" +
"WHERE ContractsOrdersPhysfaces_ID=orders_admission.ContractsOrdersPhysfaces_ID)) \n" +
"INNER JOIN teachers ON teachers.Teacher_ID=orders_admission.Teacher_ID \n" +
"INNER JOIN status_orders ON status_orders.StatusOrder_ID=orders_admission.StatusOrder_ID WHERE OrderAdmission_ID="+id);
            while(rs.next()){
                order.setOrderAdmission_ID(rs.getInt("OrderAdmission_ID"));
                order.setContractsOrdersPhysfaces_ID(rs.getInt("ContractsOrdersPhysfaces_ID"));
                order.setCource(rs.getString("Cource"));
                order.setDateBeginScience(rs.getDate("DateBeginScience"));
                order.setDateEndScience(rs.getDate("DateEndScience"));
                order.setTeacher(rs.getString("Teacher"));
                order.setStatusOrder_ID(rs.getInt("StatusOrder_ID"));
                order.setStatusOrder(rs.getString("StatusOrder"));
            }
        } catch (NamingException ex) {
            Logger.getLogger(OrderAdmissionYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderAdmissionYurfaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }
    
    public void insertOrder(OrderAdmission order) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="INSERT INTO orders_admission (ContractsOrdersPhysfaces_ID, DateBeginScience, DateEndScience, "
                + "Teacher_ID, StatusOrder_ID) "
                + "VALUES (?, ?, ?, ?, ?)";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, order.getContractsOrdersPhysfaces_ID());
        prepstmt.setDate(2, order.getDateBeginScience());
        prepstmt.setDate(3, order.getDateEndScience());
        prepstmt.setInt(4, order.getTeacher_ID());
        prepstmt.setInt(5, order.getStatusOrder_ID());
        prepstmt.executeUpdate();
    }
    
    public void updateOrder(OrderAdmission order) throws SQLException, NamingException{
        conn=Database.getConnection();
        String sql="";
        sql="UPDATE orders_admission SET ContractsOrdersPhysfaces_ID=?, DateBeginScience=?,"
                + " DateEndScience=?, Teacher_ID=?, StatusOrder_ID=?"
                + " WHERE OrderAdmission_ID=?";
        prepstmt=conn.prepareStatement(sql);
        prepstmt.setInt(1, order.getContractsOrdersPhysfaces_ID());
        prepstmt.setDate(2, order.getDateBeginScience());
        prepstmt.setDate(3, order.getDateEndScience());
        prepstmt.setInt(4, order.getTeacher_ID());
        prepstmt.setInt(5, order.getStatusOrder_ID());
        prepstmt.setInt(6, order.getOrderAdmission_ID());
        prepstmt.executeUpdate();
    }
    
    public void deleteOrder(int id) throws NamingException, SQLException{
        conn=Database.getConnection();
        stmt=conn.createStatement();
        stmt.execute("DELETE FROM orders_admission WHERE OrderAdmission_ID="+id);
    }
    
}
