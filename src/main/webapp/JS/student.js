/**
 * Created by GoldBows on 8/20/2015.
 */

$(document).ready(function(){
    //ajax call to populate subject dropdown
    $.ajax({
        url: '/recordsSystem/getSubjectListForStudent',
        type: 'GET',
        success: function (data) {
            var subjectDropdown = $("#studentSubject");
            avers_common.populateDropDown(subjectDropdown, data, 'subjectID', 'subjectCode');
        },
        error: function (e) {
            console.log(e);
        }
    });

});
