var validator;
var $fillquestionAddForm = $("#fillquestion-add-form");

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

    $("#fillquestion-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $fillquestionAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "fillquestion/add", $fillquestionAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "fillquestion/update", $fillquestionAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#fillquestion-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#fillquestion-add-button").attr("name", "save");
    $MB.closeAndRestModal("fillquestion-add");
    // validator.resetForm();
    $("#fillquestion-add-modal-title").html('新增字典');
}
