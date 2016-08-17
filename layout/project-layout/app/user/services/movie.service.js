(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q'];

    function movieService($http, $q) {

        var self = this;

        self.getMovies = getMovies;
        self.getMovieByTitle = getMovieByTitle;
        self.getReviewsByMovie = getReviewsByMovie;
        self.getMovieAvgRating = getMovieAvgRating;
        self.addReviewToMovie = addReviewToMovie;
        self.getTopRatedMovies = getTopRatedMovies;
        self.getTopVotedMovies = getTopVotedMovies;
        self.getTopRatedSeries = getTopRatedSeries;
        self.getTopVotedSeries = getTopVotedSeries;
        self.createMovie = createMovie;
        /*self.deleteMovie = deleteMovie;*/

        function getMovies() {
            return $http.get('http://localhost:8080/project-api/api/movies')
                .then(successFn, errorFn);
        }

        function getMovieByTitle(title) {
            return $http.get('http://localhost:8080/project-api/api/movies/' + title)
                .then(successFn, errorFn);
        }

        function getReviewsByMovie(title) {
            return $http.get('http://localhost:8080/project-api/api/reviews/' + title)
                .then(successFn, errorFn);
        }

        function getMovieAvgRating(title) {
            return $http.get('http://localhost:8080/project-api/api/reviews/averageRating/' + title)
                .then(successFn, errorFn);
        }

        function addReviewToMovie(review) {
            return $http.post('http://localhost:8080/project-api/api/reviews/' + review.movie_id + '/' + review.user_id, review)
                .then(successFn, errorFn);
        }

        function getTopRatedMovies() {
            return $http.get('http://localhost:8080/project-api/api/movies/topRated/movie')
                .then(successFn, errorFn);
        }

        function getTopVotedMovies() {
            return $http.get('http://localhost:8080/project-api/api/movies/topVoted/movie')
                .then(successFn, errorFn);
        }

        function getTopRatedSeries() {
            return $http.get('http://localhost:8080/project-api/api/movies/topRated/series')
                .then(successFn, errorFn);
        }

        function getTopVotedSeries() {
            return $http.get('http://localhost:8080/project-api/api/movies/topVoted/series')
                .then(successFn, errorFn);
        }

        /*
        Admin service methods
         */

        function createMovie(movie) {
            return $http.post('http://localhost:8080/project-api/api/movies', movie)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();