<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="tree${root ? ' root' : ''}">
	<span class="node"><em>${node.value}</em></span>
	<div class="children">
		<c:forEach var="child" items="${node.children}">
			<c:set var="node" value="${child}" scope="request"/>
			<c:set var="root" value="false" scope="request"/>
			<jsp:include page="_tree.jsp" />
		</c:forEach>
	</div>
</div>
