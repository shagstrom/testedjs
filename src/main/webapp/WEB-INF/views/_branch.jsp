<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<span class="node">${node.value}</span>
<div class="children">
	<c:forEach var="child" items="${node.children}">
		<div class="branch">
			<c:set var="node" value="${child}" scope="request"/>
			<jsp:include page="_branch.jsp" />
		</div>
	</c:forEach>
</div>
