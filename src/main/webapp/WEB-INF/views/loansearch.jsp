 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%@ include file="commonheader.jsp" %>
<style>
       .search-input {
        width: 250px;
        height: 35px;
      }
      .search-bar {
        position: relative;
        left: 40%;
        top: 200px;
      }
      .seacrch-btn {
        height: 35px;
        width:70px;
      }
      table{
      top:240px;
      }
    </style>
    <div class="search-page">
      <div class="search-bar">
        <input type="text" class="search-input" id="loanid"/>
        <button class="seacrch-btn" onclick="(()=>getDatas())();">search</button>
      </div>
    </div>
    
    <table id="datatable">
  <tr>
    <th>Loan Id</th>
    <th>Customer Name</th>
    <th>Loan Amount</th>
    <th>Rate of Interest</th>
    <th>Date</th>
  </tr>
  <tbody id="tablebody">
    
  </tbody>
  
</table>
    <script type="text/javascript">
     function getData(){
    	  console.log("hi");
    } 
    
   /*  getData(); */

    async function getDatas(){
    	var loanid = document.getElementById("loanid").value;
         const response= await fetch('http://localhost:8080/dashboard/getLoanEntity/'+loanid)
         console.log(response);
         const data= await response.json();
         console.log(data);
         var temp="";
       if(data.status === "success"){
            temp+="<tr>";
            temp+="<td>"+data.id+"</td>";
            temp+="<td>"+data.firstName+"</td>";
            temp+="<td>"+data.amount+"</td>";
            temp+="<td>"+data.interest+"</td>";
            temp+="<td>"+data.inititedDate+"</td>";
       }else{
    	   temp+="<tr>"+"No Loan present for this id"+"</tr>";
       }
      document.getElementById("tablebody").innerHTML=temp;
   }
    </script>
</body>
</html>