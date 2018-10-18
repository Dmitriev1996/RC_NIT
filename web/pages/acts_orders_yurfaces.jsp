<%-- 
    Document   : acts_orders_yurfaces
    Created on : 03.02.2018, 1:35:24
    Author     : Admin
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="logic.ActOrderYurface"%>
<%@page import="logic.ActOrderYurfaceList"%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/jspf/sort_panel_act_yurface.jspf" %>
        <div id="content">
         <table>
           <tr>
             <td></td>
             <td>№</td>
             <td>Дата акта</td>
             <td>Организация</td>
             <td>Курс</td>
             <td>Стоимость</td>
             <td>Дата оплаты</td>
             <td>Примечание</td>
             <td>Возврат акта</td>
           </tr>
            <% actyurfacelist=new ActOrderYurfaceList();
              for(Map.Entry<Integer, ArrayList<ActOrderYurface>> contract : actyurfacelist.getAllActList()){
            %>
            <tr>
             <td><input type="checkbox"/></td>
             <td><input type="text" name="id" size="3" value="<%=contract.getKey()%>"/></td>
             <% data=contract.getValue();
                for(ActOrderYurface str : data){
             %>
             <td><input type="text" name="" size="50" value="<%=str.getDateAct()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=str.getNameOrganization()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=str.getCource()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=str.getPrice()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=str.getDatePay()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=str.getComment()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=str.getReturnAct()%>"/></td>
             <%}%>
            </tr>
            <%}%>
         </table>
         <br>
         <form action="/WebJsp/pages/new_record.jsp">
          <input type="submit" value="Новый договор" name="new_contract"/>
         </form>
         </div>
