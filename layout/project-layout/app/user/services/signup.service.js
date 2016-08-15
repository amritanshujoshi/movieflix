(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('signupService', signupService);

    signupService.$inject = ['$http', '$q'];

    function signupService($http, $q) {

        var self = this;

        self.addUser = addUser;

        function addUser(data) {
            return $http.post('http://localhost:8080/project-api/api/movies', data)
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