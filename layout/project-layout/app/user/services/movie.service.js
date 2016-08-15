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
        self.deleteMovie = deleteMovie;

        function getMovies() {
            return $http.get('http://localhost:8080/project-api/api/movies')
                .then(successFn, errorFn);
        }

        function getMovieByTitle(title) {
            return $http.get('http://localhost:8080/project-api/api/movies/' + title)
                .then(successFn, errorFn);
        }

        function deleteMovie(title, data) {
            return $http.delete('http://localhost:8080/project-api/api/movies/' + title, data)
                .then(delSuccessFn, errorFn)
        }

        function delSuccessFn() {
            return 'Movie Deleted!!';
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();