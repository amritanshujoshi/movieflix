(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams', '$route'];

    function MovieDetailController(movieService, $routeParams, $route) {
        var movieDetailVm = this;

        movieDetailVm.reviews = [];
        movieDetailVm.avgRating = 0;

        movieDetailVm.changeSort = changeSort;
        movieDetailVm.createReview = createReview;

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

        function createReview() {

            /*
            For Testing!!
             */
            movieDetailVm.newReview.user_id = "50b36d6c-9473-44dd-837e-effd2a5e658c";
            /*
            For Testing!!
             */

            movieDetailVm.newReview.movie_id = movieDetailVm.movie.id;

                movieService
                .addReviewToMovie(movieDetailVm.newReview)
                .then(function () {
                    $route.reload();
                }, function (error) {
                    console.log(error);
                });

            movieDetailVm.newReview = {};
        }

        function changeSort(prop) {
            movieDetailVm.sorter.by = prop;
            movieDetailVm.sorter.reverse = !movieDetailVm.sorter.reverse;
        }
    }

})();