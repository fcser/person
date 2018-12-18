function checkdata(){
	//获取用户名
	var username = document.registerForm.username.value;
	//获取密码
	var password = document.registerForm.password.value;
	
	if(!checkUserName(username)){
		return false;
	}
	if(!checkPassWord(password)){
		return false;
	}
}

//判断用户名是否合理
function checkUserName(user){
	if(user.length == 0){
		alert("\请输入正确的用户名");
		registerForm.username.focus();
		return false
	}
	return true;
}
function checkPassWord(pas){
	if(pas.length < 3 || pas.length > 18){
		alert("\请输入正确的密码，密码长度为3-18位");
		registerForm.password.focus();
		return false
	}
	return true;
}
function password2Change(input){
	//获取第一次输入的密码
	var str1 = document.registerForm.password.value;
	//获取第二次输入的密码
	var str2 = input.value;
	//判断两次密码是否一致
	if (str1 == str2) {
		input.style.borderColor = "green";
		input.style.color = "green";
	} else{
		input.style.borderColor = "red";
		input.style.color = "red";
		alert("两次密码不一致");
	}
}



