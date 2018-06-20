<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" />
<title>微信JS-SDK Demo</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jssdkdemo.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=0">
</head>
<body>
	<div class="lbox_close wxapi_form">
		<h3 id="menu-basic" style="margin-top: 0px;">基础接口</h3>
		<span class="desc">判断当前客户端是否支持指定JS接口</span>
		<button class="btn btn_primary" id="checkJsApi"
			onclick="checkJsApifunction()">checkJsApi</button>

		<h3 id="menu-share">分享接口</h3>
		<span class="desc">获取“分享到朋友圈”按钮点击状态及自定义分享内容接口</span>
		<button class="btn btn_primary" id="onMenuShareTimeline">onMenuShareTimeline</button>
		<span class="desc">获取“分享给朋友”按钮点击状态及自定义分享内容接口</span>
		<button class="btn btn_primary" id="onMenuShareAppMessage">onMenuShareAppMessage</button>
		<span class="desc">获取“分享到QQ”按钮点击状态及自定义分享内容接口</span>
		<button class="btn btn_primary" id="onMenuShareQQ">onMenuShareQQ</button>
		<span class="desc">获取“分享到腾讯微博”按钮点击状态及自定义分享内容接口</span>
		<button class="btn btn_primary" id="onMenuShareWeibo">onMenuShareWeibo</button>
		<span class="desc">获取“分享到QZone”按钮点击状态及自定义分享内容接口</span>
		<button class="btn btn_primary" id="onMenuShareQZone">onMenuShareQZone</button>

		<h3 id="menu-image">图像接口</h3>
		<span class="desc">拍照或从手机相册中选图接口</span>
		<button class="btn btn_primary" id="chooseImage">chooseImage</button>
		<span class="desc">预览图片接口</span>
		<button class="btn btn_primary" id="previewImage">previewImage</button>
		<span class="desc">上传图片接口</span>
		<button class="btn btn_primary" id="uploadImage">uploadImage</button>
		<span class="desc">下载图片接口</span>
		<button class="btn btn_primary" id="downloadImage">downloadImage</button>

		<h3 id="menu-voice">音频接口</h3>
		<span class="desc">开始录音接口</span>
		<button class="btn btn_primary" id="startRecord">startRecord</button>
		<span class="desc">停止录音接口</span>
		<button class="btn btn_primary" id="stopRecord">stopRecord</button>
		<span class="desc">播放语音接口</span>
		<button class="btn btn_primary" id="playVoice">playVoice</button>
		<span class="desc">暂停播放接口</span>
		<button class="btn btn_primary" id="pauseVoice">pauseVoice</button>
		<span class="desc">停止播放接口</span>
		<button class="btn btn_primary" id="stopVoice">stopVoice</button>
		<span class="desc">上传语音接口</span>
		<button class="btn btn_primary" id="uploadVoice">uploadVoice</button>
		<span class="desc">下载语音接口</span>
		<button class="btn btn_primary" id="downloadVoice">downloadVoice</button>

		<h3 id="menu-smart">智能接口</h3>
		<span class="desc">识别音频并返回识别结果接口</span>
		<button class="btn btn_primary" id="translateVoice">translateVoice</button>

		<h3 id="menu-device">设备信息接口</h3>
		<span class="desc">获取网络状态接口</span>
		<button class="btn btn_primary" id="getNetworkType">getNetworkType</button>

		<h3 id="menu-location">地理位置接口</h3>
		<span class="desc">使用微信内置地图查看位置接口</span>
		<button class="btn btn_primary" id="openLocation">openLocation</button>
		<span class="desc">获取地理位置接口</span>
		<button class="btn btn_primary" id="getLocation">getLocation</button>

		<h3 id="menu-webview">界面操作接口</h3>
		<span class="desc">隐藏右上角菜单接口</span>
		<button class="btn btn_primary" id="hideOptionMenu">hideOptionMenu</button>
		<span class="desc">显示右上角菜单接口</span>
		<button class="btn btn_primary" id="showOptionMenu">showOptionMenu</button>
		<span class="desc">关闭当前网页窗口接口</span>
		<button class="btn btn_primary" id="closeWindow">closeWindow</button>
		<span class="desc">批量隐藏功能按钮接口</span>
		<button class="btn btn_primary" id="hideMenuItems">hideMenuItems</button>
		<span class="desc">批量显示功能按钮接口</span>
		<button class="btn btn_primary" id="showMenuItems">showMenuItems</button>
		<span class="desc">隐藏所有非基础按钮接口</span>
		<button class="btn btn_primary" id="hideAllNonBaseMenuItem">hideAllNonBaseMenuItem</button>
		<span class="desc">显示所有功能按钮接口</span>
		<button class="btn btn_primary" id="showAllNonBaseMenuItem">showAllNonBaseMenuItem</button>

		<h3 id="menu-scan">微信扫一扫</h3>
		<span class="desc">调起微信扫一扫接口</span>
		<button class="btn btn_primary" id="scanQRCode0">scanQRCode(微信处理结果)</button>
		<button class="btn btn_primary" id="scanQRCode1">scanQRCode(直接返回结果)</button>

		<h3 id="menu-shopping">微信小店接口</h3>
		<span class="desc">跳转微信商品页接口</span>
		<button class="btn btn_primary" id="openProductSpecificView">openProductSpecificView</button>

		<h3 id="menu-card">微信卡券接口</h3>
		<span class="desc">批量添加卡券接口</span>
		<button class="btn btn_primary" id="addCard">addCard</button>
		<span class="desc">调起适用于门店的卡券列表并获取用户选择列表</span>
		<button class="btn btn_primary" id="chooseCard">chooseCard</button>
		<span class="desc">查看微信卡包中的卡券接口</span>
		<button class="btn btn_primary" id="openCard">openCard</button>

		<h3 id="menu-pay">微信支付接口</h3>
		<span class="desc">发起一个微信支付请求</span>
		<button class="btn btn_primary" id="chooseWXPay">chooseWXPay</button>
	</div>
	<script src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
	<script>
		var jQuery = jQuery.noConflict(true);
	</script>
	<script type="text/javascript">
		jQuery(function() {
			//	     if (isWeiXin5() == false) {
			//           alert("您的微信版本低于 5.0，无法使用微信支付功能，请先升级！");
			//         }
			jssdk();

		});
		function jssdk() {
			jQuery
					.ajax({
						url : "${pageContext.request.contextPath}/wx/jssdk",
						type : 'post',
						dataType : 'json',
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						data : {
							'url' : location.href.split('#')[0]
						},
						success : function(data) {
							wx.config({
								debug : true,// 开启调试模式
								appId : data.jsdconfig.appId,
								timestamp : data.jsdconfig.timestamp,
								nonceStr : data.jsdconfig.nonceStr,
								signature : data.jsdconfig.signature,
								jsApiList : [ 'checkJsApi',
										'onMenuShareTimeline',
										'onMenuShareAppMessage',
										'onMenuShareQQ', 'onMenuShareWeibo',
										'hideMenuItems', 'showMenuItems',
										'hideAllNonBaseMenuItem',
										'showAllNonBaseMenuItem',
										'translateVoice', 'startRecord',
										'stopRecord', 'onRecordEnd',
										'playVoice', 'pauseVoice', 'stopVoice',
										'uploadVoice', 'downloadVoice',
										'chooseImage', 'previewImage',
										'uploadImage', 'downloadImage',
										'getNetworkType', 'openLocation',
										'getLocation', 'hideOptionMenu',
										'showOptionMenu', 'closeWindow',
										'scanQRCode', 'chooseWXPay',
										'openProductSpecificView', 'addCard',
										'chooseCard', 'openCard' ]
							});

							wx.ready(function() {// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。

							});
							wx.error(function(res) {
								alert("wx.error:" + res.errMsg);
								// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
							});
						}
					});
		}

		// 	function isWeiXin5() {
		// 		var ua = window.navigator.userAgent.toLowerCase();
		// 		var reg = /MicroMessenger\/[5-9]/i;
		// 		return reg.test(ua);
		// 	}
	</script>
	<script src="<%=request.getContextPath()%>/js/jzepto.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/demo.js?ver=001"></script>
</body>
</html>