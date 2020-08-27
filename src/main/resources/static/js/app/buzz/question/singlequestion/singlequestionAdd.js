var validator;
var $singlequestionAddForm = $("#singlequestion-add-form");

$(function() {
    // validateRule();

    $("input[name='questionStatus']").change(function() {
        var checked = $(this).is(":checked");
        var $status_label = $("#questionStatusDes");
        if (checked) {
            $status_label.html('可用');
            $("input[name='questionStatus']").val(1)
        }
        else {
            $status_label.html('禁用');
            $("input[name='questionStatus']").val(0)
        }

       console.log($("input[name='questionStatus']").val(),12321)
    });

    $("#singlequestion-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $singlequestionAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "singlequestion/add", $singlequestionAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "singlequestion/update", $singlequestionAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#singlequestion-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#singlequestion-add-button").attr("name", "save");
    $MB.closeAndRestModal("singlequestion-add");
    // validator.resetForm();
    $("#singlequestion-add-modal-title").html('新增字典');
}
