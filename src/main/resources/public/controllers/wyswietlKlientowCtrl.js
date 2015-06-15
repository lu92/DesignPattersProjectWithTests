/**
 * Created by Radek on 2015-06-13.
 */
app.controller('wyswietlKlientowCtrl', function ($scope,$http) {
    $scope.wyswietlWszystkichKlientow = "Wszyscy klienci"
    $http.get("http://localhost:8080/client/getAll").success(function (dane) {
        $scope.AllClients = dane;
    })

    $scope.usunKlienta = function (data_id) {
        var elem = {
            "value":data_id
        }
        $http.post('http://localhost:8080/client/delete',elem).success(function (dane) {
            $scope.AllClients = dane;
        })
    }
})