<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>

<body>
<h1>${message}</h1>
it is now : <fmt:formatDate value="${dateTime}" pattern="yyyy-MM-dd'T'HH:mm:ss"/>

</body>
</html>