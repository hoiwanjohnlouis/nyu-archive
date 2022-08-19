<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="age" value="${param.myage}" scope="session" />
<html>
<body>
Well, look at the bright side, you still need <c:out value="${sessionScope.age}" /> years to be <c:out value="${sessionScope.age*2}" /> years old.
<c:remove var="age" scope="session" />
</body>
</html>
