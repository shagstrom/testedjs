<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
	<head>
		<title>Tree</title>
		<link rel="stylesheet" href="<c:url value='/styles/default.css' />" type="text/css" />
		<script type="text/javascript" src="<c:url value='/scripts/prototype.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/Speedy.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/RowSelector.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/DynamicTree.js' />"></script>
		<script type="text/javascript" src="<c:url value='/scripts/main.js' />"></script>
	</head>
	<body>
		<h1>Tree</h1>
		<div class="tree">
			<c:set var="node" value="${tree}" scope="request"/>
			<jsp:include page="_branch.jsp" />
		</div>
	</body>
</html>
