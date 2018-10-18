<%-- 
    Document   : contracts
    Created on : 24.01.2018, 17:10:18
    Author     : Admin
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="logic.entity.ContractOrderYurface"%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../WEB-INF/jspf/sort_panel_contract_yurface.jspf" %>
        <div id="content">
         <table>
           <tr>
             <td></td>
             <td>№</td>
             <td>Дата договора</td>
             <td>Организация</td>
             <td>Курс</td>
             <td>Вид договора</td>
             <td>Вид оплаты</td>
             <td>Дата начала</td>
             <td>Дата окончания</td>
             <td>Стоимость</td>
             <td>Период оплаты</td>
             <td>Сумма к оплате</td>
             <td>Сумма в год</td>
             <td>Примечание</td>
             <td>Реквизиты договора</td>
             <td>Договор закрыт</td>
           </tr>
           <jsp:useBean id="yurfacecontractDAO" class="logic.dao.ContractOrderYurfaceDAO" scope="page"/>
            <% 
              for(ContractOrderYurface contract : yurfacecontractDAO.getAllContractList()){
            %>
            <tr>
             <td><input type="checkbox"/></td>
             <td><input type="text" name="id" size="3" value="<%=contract.getContractsOrdersYurfaces_ID()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDateContract()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getNameOrganization()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getCource()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getTypeContract()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getPayType()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDateBegin()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDateEnd()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getPrice()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getPayPeriod()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getSumPay()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getSumYear()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getComment()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getDetailsContract()%>"/></td>
             <td><input type="text" name="" size="50" value="<%=contract.getCloseContract()%>"/></td>
            </tr>
            <%}%>
         </table>
         <br>
         <form action="/WebJsp/pages/new_record.jsp">
          <input type="submit" value="Новый договор" name="new_contract"/>
         </form>
         </div>
