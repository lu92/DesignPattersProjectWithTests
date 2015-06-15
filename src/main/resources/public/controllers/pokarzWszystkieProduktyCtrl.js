/**
 * Created by Radek on 2015-06-14.
 */
app.controller('pokarzWszystkieProduktyCtrl', function ($scope,$http) {
    $scope.pokarz_wszystkieProdukty = "Wszystkie Produkty"

    $http.get('http://localhost:8080/baseProduct/getAll').success(function (dane) {
        $scope.AllProducts = dane;
    })

    $scope.usunProdukt = function (dane_id) {
        var elem = {
            "value":dane_id
        }
        $http.post('http://localhost:8080/baseProduct/delete',elem).success(function (dane) {
            $scope.AllProducts = dane;
        })
    }

})