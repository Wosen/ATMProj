<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>ATM</title>
</head>
 
<body>
<h2>WELCOME TO ATM</h2>
<s:actionerror />	
<s:form action="atm.action">	
    <s:password name="pinNbr" label="Enter PIN" id="pinNbr"/>   
    <s:submit method="accntBal" value="Submit" onclick="submitForm()"/>    
</s:form>
</body>

<script> 
$('form').submit(function () {
    var pinNum = $.trim($('#pinNbr').val());
    if (pinNum  === '' ){
        alert('Please enter pin number!');
        return false;
    }else if(pinNum.length < 4){
    	alert('Invalid PIN! Please try again.');
        return false;
    }
});
</script>

</html> 