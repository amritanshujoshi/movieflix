(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('signupService', signupService);

    signupService.$inject = ['$http', '$q'];

    function signupService($http, $q) {

        var self = this;

        self.createUser = createUser;

        function createUser(data) {
            return $http.post('http://localhost:8080/project-api/api/users', data)
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