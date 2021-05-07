<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${errors != null}">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors}">
                    ・<c:out value="${error}"/><br />
                </c:forEach>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${user != null}">
                <h2>${user.name}さんの従業員情報 編集ページ</h2>
                <form method="post" action="<c:url value='/users/update' />">
                    <p>ログインID : ${user.login_id} </p>
                    <br/>

                    <label for="name">氏名</label><br/>
                    <input type="text" name="name" value="${user.name}"/>
                    <br/><br/>

                    <label for="admin_flag">権限</label><br/>
                    <select name="admin_flag">
                        <option value="0"<c:if test="${user.admin_flag == 0}">selected</c:if>>一般</option>
                        <option value="1"<c:if test="${user.admin_flag == 1}">selected</c:if>>管理者</option>
                    </select>
                    <br /><br />

                    <input type="hidden" name="_token" value="${_token}"/>
                    <button type="submit">変更</button>
                </form>

                <p><a href="#" onclick="confirmDestroy();">この従業員情報を削除する</a></p>
                <form method="post" action="<c:url value='/users/destroy?id=${user.id}'/>">
                    <input type="hidden" name="_token" value="${_token}"/>
                </form>
                <script>
                    function confirmDestroy(){
                        if(confirm("本当に削除してよろしいですか？")){
                            document.forms[1].submit();
                        }
                    }
                </script>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/users/index'/>">トップページに戻る</a>
    </c:param>
</c:import>