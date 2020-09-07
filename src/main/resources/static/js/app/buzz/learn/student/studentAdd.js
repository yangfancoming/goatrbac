var validator;
var $studentAddForm = $("#student-add-form");

$(function() {
    // validateRule();
    // 点击保存按钮
    $("#student-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $studentAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "student/add", $studentAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "student/update", $studentAddForm.serialize(), function(r) {
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
    $("#student-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#student-add-button").attr("name", "save");
    $MB.closeAndRestModal("student-add");
    // validator.resetForm(); // doit  这里放开后 为啥报错？？？
    $("#student-add-modal-title").html('新增科目');
}
