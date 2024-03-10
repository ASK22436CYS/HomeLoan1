
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
    <div>
    
      <div class="common-header">
        <nav>
          <ul>
            <li><a href="/dashboard">Home</a></li>
           <li><a href="/dashboard/applyLoan">New Loan</a></li>
            <li><a href="/dashboard">Track Loan</a></li>
            <li><a href="/dashboard/loanOfferings">LoanOffers</a></li>
            <li><a href="/logout">logout</a></li>
          </ul>
          
        </nav>
      </div>
    </div>
    <style>
     nav ul li:first-child {
        margin-right: auto; /* Push the logo/image to the left */
      }
      nav {
        justify-content: center;
        padding-left: 891px;
        padding-top: 25px;
      }
      nav ul {
        list-style-type: none; /* Remove default bullet points */
        margin: 0;
        padding: 0;
      }
	nav ul img{
	justify-content: left
	padding-left:20px
	}
      nav ul li {
        display: inline; /* Display the list items horizontally */
      }

      nav ul li a {
        color: #fff; /* White text color for links */
        text-decoration: none; /* Remove default underline */
        padding: 25px 22px; /* Add padding to the links */
      }

      nav ul li a:hover {
        background-color: #a9a5e4; /* Darken the background color on hover */
      }

      table,
      td,
      th {
        border: 1px solid;
      }

      table {
        width: 50%;
        border-collapse: collapse;
        position: relative;
        left: 24%;
        top: 180px;
      }
      .common-header {
        background-color: #6a64f1;
        height: 70px;
      }
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      body {
        font-family: "Inter", sans-serif;
      }
       .common-header button {
        
   	
       
       boder:10px;	
        font-size: 1.2rem;
      } 
    </style>

    <!-- <table>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
      </tr>
      <tr>
        <td>Peter</td>
        <td>Griffin</td>
      </tr>
      <tr>
        <td>Lois</td>
        <td>Griffin</td>
      </tr>
    </table> -->
  </body>
</html>