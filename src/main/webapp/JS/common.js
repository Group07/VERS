/**
 * Created by Amila on 7/21/2015.
 */

var avers_common = (function() {

    var populateDropDown = function(dropDown,data,valueString,nameString) {
        dropDown.empty();
        $.each(data, function () {
            dropDown.append($("<option></option>").val(this[valueString]).html(this[nameString]));
        });
    };

    return {
        populateDropDown:populateDropDown
    }
})();