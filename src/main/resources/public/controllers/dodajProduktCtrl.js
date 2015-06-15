/**
 * Created by Radek on 2015-06-13.
 */
app.controller('dodajProduktCtrl', function ($scope,$http) {
    $scope.dodajNowyProduktName = "Dodaj nowy produkt";


    $http.get('http://localhost:8080/category/getAll').success(function (dane) {
        $scope.AllCategories = dane;
    })

    $scope.stworzNowyProdukt = function (produkt) {
        $http.post('http://localhost:8080/baseProduct/createProduct',produkt).success(function (dane) {
            $scope.newProduct = {}
            $scope.AllProducts = dane;
        })
    }


})