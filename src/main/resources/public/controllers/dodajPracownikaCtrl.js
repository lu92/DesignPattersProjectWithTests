/**
 * Created by Radek on 2015-06-13.
 */
app.controller('dodajPracownikaCtrl', function ($scope, $http) {
    $scope.dodajPracownikaNazwa = "dodaj nowego pracownika "
    $scope.dodajOsobe = function (dane) {
        $scope.wejscie = "wszedlem do dodawania "
        $http.post('http://localhost:8080/person/create',dane).success(function (dane) {
            $scope.newPerson = {}
        })
    }
})