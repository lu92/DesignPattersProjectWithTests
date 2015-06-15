/**
 * Created by Radek on 2015-06-13.
 */
app.controller('dodajNowaUslugeCtrl', function ($scope,$http) {
    $scope.dodajNowaUslugetext = "Wyswietl pracownikow "

    $http.get('http://localhost:8080/person/getAll').success(function (dane) {
        $scope.AllWorkers = dane;
    })

    $scope.usunPracownika = function (data_id) {
        var elem = {
            "value":data_id
        }
        $http.post('http://localhost:8080/person/delete',elem).success(function (dane) {
            $scope.AllWorkers = dane;
        })
    }
})