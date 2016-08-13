(function () {
    'use strict';

    angular
        .module('movieflix', ['ngRoute', 'ngMessages'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/user/movies', {
                templateUrl: 'app/user/views/movies.tmpl.html',
                controller: 'MoviesController',
                controllerAs: 'moviesVm'
            })
            .otherwise({
                redirectTo: '/users/movies'
            });
            /*.when('/user/movie/:id', {
                templateUrl: 'app/user/views/movie-detail.tmpl.html',
                controller: "MovieDetailsController",
                controllerAs: 'movieDetailVm'
            })
            .when('/admin/movies', {
                templateUrl: 'app/admin/views/movies.tmpl.html',
                controller: "MoviesAdmController",
                controllerAs: "moviesAdmVm"
            })
            .when('/admin/movie/')*/
    }

})();
