(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('SignupController', SignupController);

    SignupController.$inject = ['signupService', '$location'];

    function SignupController(signupService, $location) {
        var signupVm = this;

        signupVm.addUser = addUser;

        init();

        function init() {
            console.log('SignupController');
        }

        function addUser() {
            signupService
                .createUser(signupVm.newUser)
                .then(function (data) {
                    $location.path('/login');
                }, function (error) {
                    console.log(error);
                })
        }
    }
})();