$(document).ready(function () {
    /* 自定义监听器 */
    listenerChangePassword();
    /* 初始化 */
    initChangePassword();
});


function initChangePassword() {

}

function listenerChangePassword() {
    //修改
    $("#submitChangePassword").on("click", function (e) {
        // alert("确认");
        var flag = submitChangePasswordValid(e);
        if (flag) {
            var password = $("#newPassword").val();
            $.ajax({
                //请求方式
                type: "POST",
                async: false,
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url: getRootPath() + "/userInfo/changPassword/",
                //数据，json字符串
                data: password,
                //请求成功
                success: function (result) {
                    // console.log(result);
                    if (result == true) {
                        showTipsChooseInfo("修改成功");
                    }else {
                        showTipsInfo("修改失败")
                    }
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    console.log(e.status);
                    console.log(e.responseText);
                }
            });
        }
    })

    //取消
    $("#cancelChangePassword").on("click", function () {
        alert("取消");
    })


}

function showChangePassword() {
    $('#changePassword').modal({
        show: true,
        backdrop: 'static'
    });
}


function submitChangePasswordValid(e) {
    if ($("#oldPassword").val() == "" || $("#repassword").val() == "") {
        showTipsInfo("原密码不能为空");
        e.preventDefault();
        return false;
    } else {
        var password = $("#oldPassword").val();
        var flag = false;
        $.ajax({
            //请求方式
            type: "POST",
            async: false,
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url: getRootPath() + "/userInfo/confirmPassword/",
            //数据，json字符串
            // data : JSON.stringify(password),
            data: password,
            //请求成功
            success: function (result) {
                console.log(result);
                if (result == false) {
                    showTipsInfo("原密码不正确");
                    return false;
                }else {
                    flag = true;
                }
            }
            //请求失败，包含具体的错误信息
            // error : function(e){
            //     console.log(e.status);
            //     console.log(e.responseText);
            // }
        });
        if(flag == false){
            return false;
        }
    }
    if ($("#newPassword").val() == "" || $("#newPassword").val() == "") {
        showTipsInfo("新密码不能为空");
        e.preventDefault();
        return false;
    }
    if ($("#newPassword").val() != $("#rePassword").val()) {
        showTipsInfo("两次密码输入不一致");
        e.preventDefault();
        return false;
    }
    if ($("#newPassword").val().length < 6 || $("#newPassword").val().length > 20) {
        showTipsInfo("密码长度为6--20位");
        e.preventDefault();
        return false;
    }

    return true;
}


function showTipsInfo(titleInfo){
    $("#tipsPassInfo").html("");
    $("#tipsPassInfo").html(titleInfo);
    $('#tipsPass').modal({
        show: true,
        backdrop:'static'
    });
}

function showTipsChooseInfo(titleInfo){
    $("#choosePassInfo").html("");
    $("#choosePassInfo").html(titleInfo);
    $('#choosePass').modal({
        show: true,
        backdrop:'static'
    });
}

function primaryChang(){
    $("#logout").submit();
}
