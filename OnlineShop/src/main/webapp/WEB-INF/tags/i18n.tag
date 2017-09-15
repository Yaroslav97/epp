<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div align="right">
    <%-- <a href="/OnlineShop/i18n?lang=en"> ENG </a> / <a href="/OnlineShop/i18n?lang=ru"> RU </a> --%>
    <a href="${requestScope['javax.servlet.forward.request_uri']}?lang=en_US"> ENG </a> / <a href="${requestScope['javax.servlet.forward.request_uri']}?lang=ru"> RU </a>
</div>