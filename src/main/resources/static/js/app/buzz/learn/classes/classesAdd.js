var validator;
var $classesAddForm = $("#classes-add-form");

$(function() {
    // validateRule();
    // 点击保存按钮
    $("#classes-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $classesAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "classes/add", $classesAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "classes/update", $classesAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    // 点击关闭按钮
    $("#classes-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#classes-add-button").attr("name", "save");
    $MB.closeAndRestModal("classes-add");
    // validator.resetForm(); // doit  这里放开后 为啥报错？？？
    $("#classes-add-modal-title").html('新增科目');
}
