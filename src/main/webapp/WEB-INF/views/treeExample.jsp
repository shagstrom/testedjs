<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
	<head>
		<title>Tree</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css' />" type="text/css" />
		<script type="text/javascript" src="<c:url value='/scripts/lib/prototype.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/lib/DynamicTree.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/treeExample.js' />"></script>
	</head>
	<body>
		<h1>Tree</h1>
		<c:set var="node" value="${tree}" scope="request"/>
		<c:set var="root" value="true" scope="request"/>
		<jsp:include page="_tree.jsp" />
	</body>
</html>
