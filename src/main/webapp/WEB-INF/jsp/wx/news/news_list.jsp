<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>活动列表</title>
<%@include file="/common/taglib.jsp"%>
<jsp:include page="/common/_head.jsp"></jsp:include>
</head>
<body ontouchstart>
	<div class="weui-panel__bd">
		<c:forEach items="${results.resultList}" var="e">
			<a href="${e.url }" class="weui-media-box weui-media-box_appmsg">
				<div class="weui-media-box__hd">
					<img src="../../images/activity_default.jpg" width="60px"
						height="60px">
				</div>
				<div class="weui-media-box__bd">
					<h4 class="weui-media-box__title">${e.title }</h4>
					<p class="weui-media-box__desc weui-cell__ft">
						<fmt:formatDate value="${e.modifyTime}"
							pattern="yyyy-MM-dd" />
					</p>
				</div>
			</a>
		</c:forEach>
	</div>
	<jsp:include page="/common/_foot.jsp"></jsp:include>
	<script>
		$(function() {

		});
	</script>
</body>
</html>