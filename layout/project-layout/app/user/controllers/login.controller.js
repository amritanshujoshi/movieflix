(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['loginService', '$location'];

    function LoginController(loginService, $location) {
        var loginVm = this;

        loginVm.loginUser = loginUser;
        loginVm.redirectToSignup = redirectToSignup;

        init();

        function init() {
            console.log('LoginController');
        }

        function redirectToSignup() {
            $location.path('/signup');
        }

        function loginUser() {
            loginService
                .loginUser(loginVm)
                .then(function (data) {
                    $location.path('/user/movies');
                }, function (error) {
                    console.log(error);
                })
        }
    }
})();