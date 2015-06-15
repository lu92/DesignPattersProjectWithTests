/**
 * Created by Radek on 2015-06-13.
 */
app.controller('dodajNowaUsluge', function ($scope,$http) {
    $scope.dodajNowaUslugeTexts = "dodaj nowa usluge"

    //$scope.allCategories = [
    //    {"id":1,"name":"Nabial"},
    //    {"id":2,"name":"Szklo"},
    //    {"id":3,"name":"Plastik"}
    //
    //]
    //
    //$scope.allWarkers = [
    //    {"id":1,"name":"Adam"},
    //    {"id":2,"name":"Kamil"},
    //    {"id":3,"name":"Pawel"}
    //
    //]

    $http.get('http://localhost:8080/category/getAll').success(function (dane) {
        $scope.AllCategories = dane;
    })

    $http.get('http://localhost:8080/person/getAll').success(function (dane) {
        $scope.AllWorkers = dane;
    })

    $scope.stworzNowAUsluge = function (usluga) {
        $http.post('http://localhost:8080/baseProduct/createService',usluga).success(function (dane) {
            $scope.newProduct = {}
        })
    }

})