var myApp = angular.module('myApp', []);
myApp.controller('myController', function ($scope, $http) {

    //Initialize page with default data which is blank in this example
    $scope.form = {
        latitude: "",
        longitude: "",
    };

    _refreshPageData();

    //HTTP get methods
    function _refreshPageData() {
        $http.get('/nearest-flight/demo/flight')
            .then(function (response) {
                $scope.jsondata = response.data;
                console.log("status:" + response.status);
            }).catch(function (response) {
            console.error('Error occurred:', response.status, response.data);
        }).finally(function () {
            console.log("Task Finished.");
        });
    }

    //HTTP PUT methods
    $scope.checkFlight = function () {
        $http({
            method: "POST",
            url: '/nearest-flight/demo/checkflight',
            data: angular.toJson($scope.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    function _success(response) {
        _refreshPageData();
        _clearForm()
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearForm() {
        $scope.form.latitude = "";
        $scope.form.longitude = "";
    };


});