(function () {
    'use strict';

    angular
        .module('movieflix', ['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: 'app/user/views/signup.tmpl.html',
                controller: 'SignupController',
                controllerAs: 'signupVm'
            })
            .when('/user/movies', {
                templateUrl: 'app/user/views/movies.tmpl.html',
                controller: 'MoviesController',
                controllerAs: 'moviesVm'
            })
            .when('/user/movies/:title', {
                templateUrl: 'app/user/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm'
            })
            .when('/admin/movies', {
                templateUrl: 'app/admin/views/movies.tmpl.html',
                controller: 'MoviesAdminController',
                controllerAs: 'moviesAdminVm'
            })
            .otherwise({
                redirectTo: '/admin/movies'
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
