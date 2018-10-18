<%-- 
    Document   : new_record
    Created on : 08.01.2018, 19:51:14
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="logic.Yurface" %>
<%@ page import="logic.YurfaceList" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/jspf/sidebar.jspf" %>
        <div id="content">
          <table>
            <tr>
              <td>№</td>
              <td>Организация</td>
              <td>Директор</td>
              <td>Юр.адрес</td>
              <td>Факт.адрес</td>
              <td>Телефон/факс</td>
              <td>E-mail</td>
          <%
              ArrayList<Yurface> data;
              YurfaceList yurfacelist=new YurfaceList();
              for(Map.Entry<Integer, ArrayList<Yurface>> yurface : yurfacelist.getYurfaceList()){
          %>
          <tr>
            <td><input type="checkbox"/></td>
            <td><input type="text" name="id" size="3" value="<%=yurface.getKey()%>"/></td>
            <% data=yurface.getValue();
                for(Yurface str : data){
             %>
            <td><input type="text" name="" size="50" value="<%=str.getNameOrganization()%>"/></td>
            <td><input type="text" name="" size="50" value="<%=str.getDirector()%>"/></td>
            <td><input type="text" name="" size="50" value="<%=str.getYurAdress()%>"/></td>
            <td><input type="text" name="" size="50" value="<%=str.getFactAdress()%>"/></td>
            <td><input type="text" name="" size="50" value="<%=str.getPhoneFax()%>"/></td>
            <td><input type="text" name="" size="50" value="<%=str.getEmail()%>"/></td>
            <%}%>
            </tr>
            <%}%>
         </table>
         <br>
         <form class="submit_button" action="/WebJsp/pages/new_record.jsp">
           <input type="submit" value="Добавить юр.лицо" name="new_yurface"/>
         </form>
         <form class="submit_button" action="/WebJsp/pages/new_record.jsp">
            <input type="submit" value="Добавить слушателя" name="new_student">
         </form>
         </form>
         </div>
