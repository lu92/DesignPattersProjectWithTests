/**
 * Created by Radek on 2015-06-14.
 */
app.controller('zluzZamowienieCtrl', function ($scope,$http) {
    $scope.StronaDoSkladaniaZamowien = "wybierz produkty"

    $scope.stronaAktualna = 0;

    $scope.dalej = function(){
        $scope.stronaAktualna = 1;
    }

    $scope.czyPokazac = function (id_strony) {
        return id_strony == $scope.stronaAktualna ? true: false;
    }

    $scope.aktualnaKategoria = ""

    $http.get('http://localhost:8080/baseProduct/getAll').success(function (dane) {
        $scope.AllProducts = dane;
    })

    $scope.ilosc_w_koszyku = function () {
        return $scope.zamowienie.length;
    }

    $scope.zamowienie = [
        //{"id":-1}
    ]

    $scope.dodajProdukt = function (item) {
        //item.showButton = false;
        $scope.zamowienie.push(item)
    }

    $scope.obliczCene = function(podatek){
        var elem  = {
            "taxationType":podatek,
            "productDTOInfos":this.zamowienie
        }
        $http.post('http://localhost:8080/orderDetails/obliczPodatek',elem).success(function (dane) {
            $scope.cena_za_podatek = dane;
        })
    }

    $scope.jestWKoszyku = function (_idProduktu) {
        //for(var i = 0 ; i< $scope.zamowienie.length; i++){
        //    if($scope.zamowienie.get(i) == _idProduktu){
        //        return true;
        //    }
        //}4
        return true;
    }
})