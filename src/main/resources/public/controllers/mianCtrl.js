/**
 * Created by Radek on 2015-06-09.
 */
var app = angular.module('app',['ngRoute']);

app.config(function($routeProvider){
    $routeProvider.when('/',{
        templateUrl: 'view/home.html'
    });
    $routeProvider.when('/dodajPracownika',{
        templateUrl: 'view/dodajPracownika.html'
    });
    $routeProvider.when('/dodajKlienta',{
        templateUrl: 'view/dodajKlienta.html'
    });
    $routeProvider.when('/dodajProdukt',{
        templateUrl: 'view/dodajProdukt.html'
    });
    $routeProvider.when('/wyswietlOsoby',{
        templateUrl: 'view/wyswietlOsoby.html'
    });
    $routeProvider.when('/dodajKategorie',{
        templateUrl: 'view/dodajKategorie.html'
    });
    $routeProvider.when('/dodajNowaUsluge',{
        templateUrl: 'view/dodajNowaUsluge.html'
    });
    $routeProvider.when('/wyswietlKlientow',{
        templateUrl: 'view/wyswietlKlientow.html'
    });
    $routeProvider.when('/WyswietlProdukty',{
        templateUrl: 'view/wysweitlProdukty.html'
    });



    $routeProvider.when('/zluzZamowienie',{
        templateUrl: 'view/zluzZamowienie.html'
    });
    $routeProvider.when('/OdebraneWiadomosci',{
        templateUrl: 'view/OdebraneWiadomosci.html'
    });
    $routeProvider.when('/NieodebraneWiadomosci',{
        templateUrl: 'view/NieodebraneWiadomosci.html'
    });
    $routeProvider.when('/ZobaczZamowienia',{
        templateUrl: 'view/ZobaczZamowienia.html'
    });
    $routeProvider.when('/ZobaczDaneKontaktowe',{
        templateUrl: 'view/ZobaczDaneKontaktowe.html'
    });
});

app.controller('mainAppCtrl', function ($scope,$http) {
    $scope.pageName = "Projekt na wzorce projektowe";
    $scope.loginStatus = true;
    $scope.invalidDataAccount = true;

    $scope.PersonType = 3;

    $scope.sprawdzStatus = function (str) {
        //return str==this.PersonType? true: false;
        return true;
    }




    $scope.loginLucjan = function (userData) {
        $http.post('http://localhost:8080/person/login',userData).success(function (data) {
            var dane = data;
            if(dane.name=='fake'){

            }
            else{
                if(dane.personType == 'MANAGER'){
                    $scope.PersonType = 1;
                }
                else if(dane.personType == 'WORKER'){
                    $scope.PersonType = 2;
                }
                else if(dane.personType == 'CLIENT'){
                    $scope.PersonType = 3;
                }
                $scope.loginStatus = true;
            }
        })
    }

    $scope.sprawdzStatus = function(nr){
        return nr == this.PersonType ? true:false;
    }



    $scope.logOutFunction = function () {
        this.loginStatus = false;
        $scope.UserLoginInfo = {};
        $scope.userData = {};
    };

    //$interval(function(){
    //
    //    $http.get("admin.json").success(function(data){
    //        $scope.pages = data;
    //    })
    //},10,1)

});



