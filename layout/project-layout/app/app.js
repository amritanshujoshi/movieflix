(function () {
    'use strict';

    angular
        .module('movieflix', ['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: 'app/user/views/login.tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/signup', {
                templateUrl: 'app/user/views/signup.tmpl.html',
                controller: 'SignupController',
                controllerAs: 'signupVm'
            })
            .when('/user/movies', {
                templateUrl: 'app/user/views/movies.tmpl.html',
                controller: 'MoviesController',
                controllerAs: 'moviesVm'
            })
            .when('/user/movies/topRated', {
                templateUrl: 'app/user/views/movies-top-rated.tmpl.html',
                controller: 'MoviesTopRatedController',
                controllerAs: 'moviesTopRatedVm'
            })
            .when('/user/movies/topVoted', {
                templateUrl: 'app/user/views/movies-top-voted.tmpl.html',
                controller: 'MoviesTopVotedController',
                controllerAs: 'moviesTopVotedVm'
            })
            .when('/user/series/topRated', {
                templateUrl: 'app/user/views/series-top-rated.tmpl.html',
                controller: 'SeriesTopRatedController',
                controllerAs: 'seriesTopRatedVm'
            })
            .when('/user/series/topVoted', {
                templateUrl: 'app/user/views/series-top-voted.tmpl.html',
                controller: 'SeriesTopVotedController',
                controllerAs: 'seriesTopVotedVm'
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
            .when('/admin/addMovie', {
                templateUrl: 'app/admin/views/movie-add.tmpl.html',
                controller: 'MoviesAdminController',
                controllerAs: 'moviesAdminVm'
            })
            .when('/admin/editMovie/:title', {
                templateUrl: 'app/admin/views/movie-edit.tmpl.html',
                controller: 'MovieEditController',
                controllerAs: 'movieEditVm'
            })
            .otherwise({
                redirectTo: '/login'
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
