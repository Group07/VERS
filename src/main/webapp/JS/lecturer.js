/**
 * Created by Amila on 7/21/2015.
 */
$(document).ready(function () {

    $.ajax({
        url: '/recordsSystem/getSubjectList',
        type: 'GET',
        success: function (data) {
            //called when successful
            console.log(data);
            var subjectDropdown = $("#studentSubject");
            subjectDropdown.empty();
            $.each(data, function () {
                subjectDropdown.append($("<option></option>").val(this['subjectCode']).html(this['subjectName']));
            });
        },
        error: function (e) {
            //called when there is an error
            //console.log(e.message);
            console.log(e);
        }
    });


});