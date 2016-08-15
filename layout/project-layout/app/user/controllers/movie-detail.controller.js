(function() {
    'use strict';

    angular.module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams'];

    function MovieDetailController(movieService, $routeParams) {
        var movieDetailVm = this;

        init();

        function init() {

            movieService
                .getMovieByTitle($routeParams.title)
                .then(function (movie){
                    movieDetailVm.movie = movie;
                }, function (error) {
                    console.log(error);
                });
        }
    }

})();