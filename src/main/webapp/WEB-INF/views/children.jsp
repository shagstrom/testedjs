<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="child" items="${children}">
	<div class="branch">
		<c:set var="node" value="${child}" scope="request"/>
		<jsp:include page="_branch.jsp" />
	</div>
</c:forEach>
