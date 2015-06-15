/**
 * Created by Radek on 2015-06-13.
 */
app.controller('dodajKlientaCtrl', function ($scope,$http) {
    $scope.dodajKlientaName = "Dodaj nowego klienta"
    
    $scope.dodajKlientaa = function (klient) {
        $http.post('http://localhost:8080/client/create', klient).success(function (dane) {
            $scope.newPerson = {}
        })
    }
})