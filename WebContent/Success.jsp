<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Request Completed</title>
</head>
 
<body>
<s:form action="atm.action">
	<p>Request Completed</p>
	
	<p>
		Current Balnce is: $
    	<s:property value="blcAmt" />
    </p>
</s:form>
</body>
</html> 