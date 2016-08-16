(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams'];

    function MovieDetailController(movieService, $routeParams) {
        var movieDetailVm = this;

        movieDetailVm.reviews = [];
        movieDetailVm.avgRating = 0;

        movieDetailVm.changeSort = changeSort;

        init();

        function init() {

            movieDetailVm.sorter = {
                by: 'rating',
                reverse: false
            };

            movieService
                .getMovieByTitle($routeParams.title)
                .then(function (movie) {
                    movieDetailVm.movie = movie;
                }, function (error) {
                    console.log(error);
                });

            movieService
                .getReviewsByMovie($routeParams.title)
                .then(function (reviews) {
                    movieDetailVm.reviews = reviews;
                }, function (error) {
                    console.log(error);
                });

            movieService
                .getMovieAvgRating($routeParams.title)
                .then(function (rating) {
                    movieDetailVm.avgRating = rating;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            movieDetailVm.sorter.by = prop;
            movieDetailVm.sorter.reverse = !movieDetailVm.sorter.reverse;
        }
    }

})();