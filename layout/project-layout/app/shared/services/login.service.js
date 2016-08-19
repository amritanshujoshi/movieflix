(function () {
    'use strict';

    angular
        .module('movieflix')
        .service('loginService', loginService);

    loginService.$inject = ['$http', '$q'];

    function loginService($http, $q) {

        var self = this;

        self.loginUser = loginUser;

        function loginUser(data) {
            return $http.post('http://localhost:8080/project-api/api/users/login', data)
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