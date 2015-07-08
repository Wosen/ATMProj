<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cash Withdraw</title>
</head>
 
<body>
<s:form action="atm.action">
	<p>
		Just withdrew: $
		<s:property value="wtdrwAmnt" />
	</p>
	
	<p>
		Current Balnce is: $
    	<s:property value="blcAmnt" />
    </p>
    
</s:form>
</body>
</html> 