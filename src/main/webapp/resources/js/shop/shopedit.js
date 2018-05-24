$(function () {
    $.getJSON("/o2o/shop/getshopinitinfo", function (data) {
        if (data.success) {
            var tempCategoryHtml = '';
            var tempAreaHtml = '';
            $.each(data.shopCategoryList, function (index, item) {
                tempCategoryHtml += '<option data-id="' + item.shopCategoryId + '">' + item.shopCategoryName + '</option>';
            });

            $.each(data.areaList, function (index, item) {
                tempAreaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
            });
            $("#shop-category").html(tempCategoryHtml);
            $("#shop-area").html(tempAreaHtml);
        }
    });
    $("#kaptcha_img").click(function () {
        changeVerifyCode(this);
    });


    $("#submit").click(function () {
        var shop = {};
        shop.shopName = $("#shop-name").val();
        shop.shopAddr = $("#shop-addr").val();
        shop.shopDesc = $("#shop-desc").val();
        shop.phone = $("#shop-phone").val();
        shop.area = { //$("#shop-area > option:selected").data('id')
            areaId:$("#shop-area").find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        shop.shopCategory = {//$("#shop-category > option:selected").data('id')
            shopCategoryId:$("#shop-category").find('option').not(function () {
                return !this.selected;
            }).data('id')
        };

        var formdata = new FormData();
        formdata.append("shopStr",JSON.stringify(shop));
        formdata.append("shopImg",$("#shop-img")[0].files[0]);
        var verifyCode = $("#kaptcha").val();
        if (!verifyCode){
            $.toast('请输入验证码');
            return;
        }
        formdata.append("verifyCode",verifyCode);
        $.ajax({
            url:"/o2o/shop/registershop",
            data:formdata,
            type:"post",
            contentType:false,
            processData:false,
            success:function (data) {
                if(data.success){
                    $.toast('提交成功');
                }else {
                   $.toast(data.errMsg);
                }
            },
            error:function (xhr) {
                $.toast(xhr.status + "错误");
            }
        });



    });








});