<%@ page language="java" import="java.util.*"
         pageEncoding="gbk" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>checkbox Tag Example</title>
    <style type="text/css">@import url(css/main.css);</style>
    <style type="text/css">
        .errorMessage {
            color: red;
        }
    </style>
</head>
<body>
<div id="global" style="width:300px">
    <s:fielderror/>
    <s:form action="check.action"  validate="true">
        <s:textfield label="�û���" name="username"/>
        <s:password label="��������" name="password"/>
        <s:password label="ȷ������" name="password2"/>
        <s:textfield label="����" name="email"/>
        <s:submit/>
    </s:form>
</div>
</body>
</html>

