/**
 * Created by Amila on 7/21/2015.
 */
$(document).ready(function () {

    //ajax call to populate subject dropdown
    $.ajax({
        url: '/recordsSystem/getSubjectList',
        type: 'GET',
        success: function (data) {
            var subjectDropdown = $("#studentSubject");
            avers_common.populateDropDown(subjectDropdown, data, 'subjectID', 'subjectCode');
        },
        error: function (e) {
            console.log(e);
        }
    });

    //ajax call to populate student dropdown
    $.ajax({
        url: '/recordsSystem/getStudentList',
        type: 'GET',
        success: function (data) {
            var subjectDropdown = $("#studentRegNum");
            avers_common.populateDropDown(subjectDropdown, data, 'studentID', 'studentRegNumber');
        },
        error: function (e) {
            console.log(e);
        }
    });


});