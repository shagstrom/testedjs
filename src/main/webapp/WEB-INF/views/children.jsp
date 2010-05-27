<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="child" items="${children}">
	<c:set var="node" value="${child}" scope="request"/>
	<jsp:include page="_tree.jsp" />
</c:forEach>
