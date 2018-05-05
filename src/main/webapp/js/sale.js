$(function() {
    $("form").validate({
        errorElement: "span",
        rules: {
            price: {
                required: true,
                digits: true
            },
            quantity: {
                required: true,
                number: true,
                min: 1
            }
        },
        messages: {
            price: {
                required: "单价不能为空！",
                digits: "单价必须是数字"
            },
            quantity: {
                required: "数量不能为空！",
                number: "数量必须是数字",
                min: "数量必须大于等于{0}"
            }
        }
    });
});
function fun() {
    var select = document.getElementById("productId").value;
    if (select == ""){
       alert("请选择商品！");
        return false;
    }
}
