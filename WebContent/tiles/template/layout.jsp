<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
	<script type="text/javascript" src="/semiP/assets/js/menuscroll.js"></script>
</head>
<body>
	<tiles:insertAttribute name="sidebar" />
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	
</body>
</html>