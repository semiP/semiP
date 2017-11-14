<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- 익스에서 문서보드 IE7 로 고정하는것 방지 -->
<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="/semiP/assets/css/common.css" type="text/css">
</head>
<body>
	<tiles:insertAttribute name="sidebar" />
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	
</body>
</html>