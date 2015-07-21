/**
 * Created by Amila on 7/21/2015.
 */
$(document).ready(function () {

    $.ajax({
        url: '/recordsSystem/getSubjectList',
        type: 'GET',
        success: function (data) {
            //called when successful
            var subjectDropdown = $("#studentSubject");
            avers_common.populateDropDown(subjectDropdown,data,'subjectCode','subjectName');
        },
        error: function (e) {
            //called when there is an error
            //console.log(e.message);
            console.log(e);
        }
    });


});