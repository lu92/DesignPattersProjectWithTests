/**
 * Created by Radek on 2015-06-13.
 */
app.controller('dodajKategorieCtrl', function ($scope,$http) {
    $scope.dodajKategorie = "dodaj nowa kategorie"

    $http.get('http://localhost:8080/category/getAll').success(function (dane) {
        $scope.AllCategories = dane;
    })

    $scope.usunKategorie = function (id_cat) {
        var elem = {
            "value":id_cat
        }
        $http.post('http://localhost:8080/category/delete',elem).success(function (dane) {
            $scope.AllCategories = dane;
        })
    }

    $scope.dodajKategoriee = function (dane) {
        $http.post('http://localhost:8080/category/create',dane).success(function (dane) {
            $scope.AllCategories = dane;
        })
    }
})