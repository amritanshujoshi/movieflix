(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q'];

    function movieService($http, $q) {

        var self = this;

        self.getMovies = getMovies;
        self.getMovieById = getMovieById;

        function getMovies() {
            return $http.get('http://localhost:8080/project-api/api/movies')
                .then(successFn, errorFn);
        }

        function getMovieById(id) {
            return $http.get('http://localhost:8080/project-api/api/movies/' + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            console.log(response.data);
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();