<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>従業員  一覧</h2>
        <table id="user_list">
            <tbody>
                <tr>
                    <th>社員のログインID</th>
                    <th>氏名</th>
                    <th>権限</th>
                    <th>情報</th>
                </tr>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${user.login_id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${user.admin_flag == 1}">管理者</c:when>
                                <c:otherwise>一般</c:otherwise>
                            </c:choose>
                        <td>
                            <c:choose>
                            <c:when test="${user.delete_flag == 1}">
                                (削除済み)
                            </c:when>
                            <c:otherwise>
                                <p><a href="#" onclick="confirmDestroy();">この社員を削除する</a>
                                <form method="post" action="<c:url value='/users/destroy'/>">
                                    <input type="hidden" name="_token" value="${_roken}"/>
                                </form>
                                <script>
                                    function confirmDestroy(){
                                        if(confirm("本当に削除してよろしいですか？")){
                                            document.forms[1].submit();
                                        }
                                    }
                                </script>
                            </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            (全 ${users_count} 件)<br />
            <c:forEach var="i" begin="1" end="${((users_count - 1) / 20) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/users/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/users/new'/>">新規従業員の登録</a></p>
    </c:param>
</c:import>