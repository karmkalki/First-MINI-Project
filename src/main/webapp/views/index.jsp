<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- for form tag library provided by spring mvc -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <!-- -for jstl  -->
    <%@ taglib  uri="jakarta.tags.core"  prefix="c"%>  
    
  <!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <h1 class="container-sm">Insurance Info</h1>
    <div   style="text-align:center">
<p ><font color='green' class="container-sm"> ${msg} </font></p>
 
  <form:form  action="search" modelAttribute="Citizenbinding" method="POST">
  
  <table cellpadding="20">
  <tr>
  <td>Plan Name:
  <form:select path="planName">
  <form:option value="">-Select-</form:option>
  <form:options items="${CName}"></form:options>
  </form:select>   
  </td>
  
   <td>Plan Status:
  <form:select path="planStatus">
  <form:option value="">-Select-</form:option>
  <form:options items="${CStatus}"></form:options>
  </form:select>   
  </td>
  
   <td>Gender:
           Male <form:radiobutton path="citizenGender" value="Male"/>  
        Female <form:radiobutton path="citizenGender" value="Female"/>  
   </td>
  </tr>
  <tr>
  <td>Start Date:
  <form:input type="date" path="startingDate"/>
  </td>
  
  <td>End Date:
  <form:input type="date" path="endingDate"/>
  </td>
  
  <td>
  <input class="btn btn-success" type="submit" value="Search" />
  </td>
  </tr>
  </table>  
  </form:form>  
  <hr>

<table class="table table-dark table-hover">
<thead>
<tr>
<td>Id</td>
<td>CitizenName</td>
<td>PlanName</td>
<td>Gender</td>
<td>PlanStatus</td>
<td>PlanBenifit</td>
<td>StartDate</td>
<td>EndingData</td>
<td>TerminateReason</td>
<td>TerminateDate</td>
<td>DeniedReason</td>
</tr>
</thead>

<tbody>
<c:forEach var="name" items="${data}">
<tr>
<td><c:out value="${name.id}"/></td>
<td><c:out value="${name.citizenName}"/></td>
<td><c:out value="${name.planName}"/></td>
<td><c:out value="${name.citizenGender}"/></td>
<td><c:out value="${name.planStatus}"/></td>
<td><c:out value="${name.planBenefit}"/></td>
<td><c:out value="${name.startingDate}"/></td>
<td><c:out value="${name.endingDate}"/></td>
<td><c:out value="${name.planTerminate}"/></td>
<td><c:out value="${name.terminateDate}"/></td>
<td><c:out value="${name.planDenied}"/></td>
</tr>
</c:forEach>
</tbody>
<tbody>
  <tr >
  <td colspan="11" style="text-align:center">
<c:if test="${empty data}">
No record available
</c:if>
</td>
</tr>
</tbody>

</table>
  <hr>
  <font >Export Format :</font>
  <a href="/export/excel">Excel</a>
<a href="/export/pdf">PDF</a>
 </div>

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>