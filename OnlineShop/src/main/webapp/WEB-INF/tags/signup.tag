<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ attribute name="login" required="true" %>
<%@ attribute name="avatar" required="true" %>

<table class="table">
    <tr>
        <td>${login}</td>
        <td><img class="img-circle" src="/OnlineShop/avatar?login=${login}" width="52" height="52"></td>
        <td><a href="/OnlineShop/logout">logout</a></td>
    </tr>
</table>