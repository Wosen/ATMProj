<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Balance</title>
</head>
 
<body>
<s:actionerror />	
<s:form action="atm.action">	
	<p>
		Your balance is: $
		<s:property value="blcAmt" />	
	</p>
	
	<p>
	<s:textfield name="wtdrwAmt"/>   
    <s:submit method="wthdrwCash" value="Withdraw Cash" align="left" /> 
    </p>   
    
    <p>
    <s:textfield name="dpstAmt"/>   
    <s:submit method="dpstCash" value="Deposit Cash" align="left" />
	</p>    
	
</s:form>

</body>
</html> 