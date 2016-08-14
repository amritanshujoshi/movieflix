(function () {
    'use strict';

    angular
        .module('movieflix', ['ngRoute'])
        .constant('CONFIG', {
            'API_HOST': 'http://localhost:8080/project-api/api'
        });
})();