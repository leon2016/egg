<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>上海校友会</title>
<jsp:include page="/common/_head.jsp"></jsp:include>
</head>
<body ontouchstart>
	<header class='demos-header'>
		<h1 class="demos-title">发布活动</h1>
	</header>
	<form id="newsForm" action="addNews" method="post">
	<input type="hidden" name="type" value = "1" />
	<input type="hidden" name="openid" value = "${openid }" />
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">活动主题</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" id="title" name="title" type="text"
						placeholder="请输入活动主题">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">报名链接</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" id="url" name="url" type="text"
						placeholder="请输入报名链接">
				</div>
			</div>
			<div class="weui-cell weui-cell_switch">
				<div class="weui-cell__bd">是否免费</div>
				<div class="weui-cell__ft">
					<input class="weui-switch" type="checkbox" name="ifCost"
						value="1" checked>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label for="" class="weui-label">开始时间</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" id="startTime" name="startTime" 
						type="datetime-local" style="font-size: 14px;">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label for="" class="weui-label">结束时间</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" id="endTime" name="endTime"
						type="datetime-local" style="font-size: 14px;">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">联系人</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="linkman" type="text" 
						placeholder="请输入联系人">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label">手机号</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="mobile" type="tel"
						placeholder="请输入手机号">
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<textarea class="weui-textarea" name="description" placeholder="活动摘要..." rows="3" onkeyup="setNowNum(this,'nowNum',200)"></textarea>
					<div class="weui-textarea-counter">
						<span id="nowNum">0</span>/200
					</div>
				</div>
			</div>
		</div>
	</form>
	<label for="weuiAgree" class="weui-agree"> <input
		id="weuiAgree" type="checkbox" class="weui-agree__checkbox" checked> <span
		class="weui-agree__text"> 阅读并同意<a href="javascript:void(0);">《相关条款》</a>
	</span>
	</label>

	<div class="weui-btn-area">
		<a class="weui-btn weui-btn_primary" href="javascript:"
			id="showTooltips">确定</a>
	</div>
	<jsp:include page="/common/_foot.jsp"></jsp:include>
	<script>
	$(function(){
		$("#showTooltips").click(function() {
			// 验证
			var title = $('#title').val();
			var url = $('#url').val();
			var startTime = $('#startTime').val();
			var endTime = $('#endTime').val();
			if(!title){
				$.toptip("请输入活动主题");
				$('#title').focus();
				return;
			}
			if(!url){
				$.toptip("请输入活动报名链接");
				$('#url').focus();
				return;
			}
			if(!startTime){
				$.toptip("请输入活动开始时间");
				$('#startTime').focus();
				return;
			}
			if(!endTime){
				$.toptip("请输入活动结束时间");
				$('#endTime').focus();
				return;
			}
			// 提交
			$("#newsForm").submit();
				
		});
		
	});
	function setNowNum(obj,id,maxNum){
		var txt = $(obj).val();
		var len = !txt?0:txt.length;
		if(maxNum<len){
			$(obj).val(txt.substr(0,maxNum));
			len = maxNum;
		}
		$("#"+id).text(len);
	}
	</script>
</body>
</html>