$(function() {
	$("form").validate({
		//把错误提示的元素由默认的label改为span
		errorElement: "span",
		//验证规则
		rules: {
			//验证<input name="cardNo" ..的元素
			userName: {
				//内置的非空验证器
				required: true
			},
            passWord: {
				required: true
			}
		},
		//自定义消息提示
		messages: {
			//自定义<input name="cardNo" ..的元素消息提示
			userName: {
				//覆盖默认的消息： "This field is required."
				required: "用户名不能为空！"
			},
            passWord: {
				required: "密码不能为空！"
			}
		}
	});
});

/*$(function() {
	$("form").submit(function() {
		var cardNo = $("#cardNo");
		var cardNoVal = $.trim(cardNo.val());
		if (cardNoVal.length == 0) {
			alert("卡号不能为空！");
			cardNo.focus();
			return false;
		}
		if (!/^\d{16}$/.test(cardNoVal)) {
			alert("请正确填写你的16位卡号！");
			cardNo.select();
			return false;
		}

		var password = $("#password");
		var passwordVal = $.trim(password.val());
		if (passwordVal.length == 0) {
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		if (!/^\d{6}$/.test(passwordVal)) {
			alert("请正确填写6位登录密码！");
			password.select();
			return false;
		}
		
		return true;
	});
});*/