(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q', 'CONFIG'];

    function movieService($http, $q, CONFIG) {

        var self = this;

        self.getMovies = getMovies;
        self.getMovieById = getMovieById;

        function getMovies() {
            return $http.get(CONFIG.API_HOST + '/movies')
                .then(successFn, errorFn);
        }

        function getMovieById(id) {
            return $http.get(CONFIG.API_HOST + '/movies/' + id)
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